package com.zhonghaijun.ssj.web.controller.info;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.zhonghaijun.ssj.validate.EmployeeExcelVerifyHandler;
import com.zhonghaijun.ssj.common.MD5Util;
import com.zhonghaijun.ssj.common.PageDate;
import com.zhonghaijun.ssj.domain.Department;
import com.zhonghaijun.ssj.domain.Employee;
import com.zhonghaijun.ssj.query.EmployeeQuery;
import com.zhonghaijun.ssj.service.DepartmentService;
import com.zhonghaijun.ssj.service.EmployeeService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @RequestMapping("/index")
    public String  index(){
        return "info/employee";
    }

    //lostinfo这是给查询出来的对象命名，解决数据丢失，在所有方法执行前会执行的方法
    @ModelAttribute("lostinfo")
    public Employee lostInfo(Employee employee,String cmd){
        if (employee.getId() != null&&"upd".equals(cmd)){
            employee = service.findOne(employee.getId());
            //修改的时候会导致数据丢失，比如头像没有上传或者密码没有修改时
            employee.setDepartment(null);
            return employee;
        }
        return employee;
    }
    //获得所有数据
    @RequestMapping("/getall")
    @ResponseBody
    public PageDate<Employee> getall(EmployeeQuery query){
        return new PageDate<Employee>(service.findPageByQuery(query));
    }
    //修改
    @RequestMapping("/upd")
    @ResponseBody
    //这是让e对象来引用上面查询出来的对象，并且在底层就对其赋值，可以让没有赋值的值有值
    public String upd(@ModelAttribute("lostinfo") Employee e){
        if (e.getDepartment().getId() == null){
            //如果没有选中部门 就直接为空
            e.setDepartment(null);
        }
        service.merge(e);
        return "修改成功";
    }
    //删除
    @RequestMapping("/del")
    @ResponseBody
    public String del(String id){
        try {
            service.del(Long.parseLong(id));
        } catch (Exception e) {
            return "删除失败";
        }
        return "删除成功!!";
    }
    //添加
    @RequestMapping("/add")
    @ResponseBody
    public String add(Employee employee){
        //如果id为空，证明就是新增
        if(employee.getId() == null){
            employee.setPassword(MD5Util.createMd5(employee.getPassword()));
        }
        service.merge(employee);
        return "添加成功!!";
    }
    //验证用户名是否重复
    @RequestMapping("/checkname")
    @ResponseBody
    public Boolean checkname(String username,Long id){
        return service.checkName(username,id);
    }
    //根据id查找
    @RequestMapping("/getone")
    @ResponseBody
    public Employee getone(Long id){
        return service.findOne(id);
    }


    //导出
    @RequestMapping("/import")
    public String imoprt(ModelMap map, EmployeeQuery query, HttpServletRequest request){
        //通过条件来查询所有的条件
        List<Employee> list = service.findAllByQuery(query);

        //解决文件下载后头像显示不出的问题
        for (Employee employee : list) {
            employee.setHeadImage(request.getServletContext().getRealPath("")+employee.getHeadImage());
        }

        //设置属性 头 标题 和导出的类型
        ExportParams params = new ExportParams("员工管理","列表", ExcelType.XSSF);
        //数据集，查询出来的集合
        map.put(NormalExcelConstants.DATA_LIST, list);
        //导出的模板对象
        map.put(NormalExcelConstants.CLASS, Employee.class);
        //设置参数
        map.put(NormalExcelConstants.PARAMS, params);
        //设置导出的文件名称
        map.put(NormalExcelConstants.FILE_NAME, "employee");
        //返回视图，会自动去找内部实现的路径
        return NormalExcelConstants.EASYPOI_EXCEL_VIEW;
    }

    //注入部门的service
    @Autowired
    private DepartmentService ds;
    @Autowired
    private  EmployeeExcelVerifyHandler employeeExcelVerifyHandler;

    //上传excel文件
    @RequestMapping("/upload")
    public String upload(MultipartFile empFile, HttpServletResponse response) throws Exception {
        //准备导入的参数
        ImportParams params = new ImportParams();
        //设置头占一行
        params.setHeadRows(1);
        //标题占一行
        params.setTitleRows(1);
        //设置参数在导入时，需要验证
        params.setNeedVerfiy(true);
        //启动自定义的验证
        params.setVerifyHandler(employeeExcelVerifyHandler);
        //从上传的文件中获取输入流,并且获得每一行的数据
        //List<Employee> list = ExcelImportUtil.importExcel(empFile.getInputStream(), Employee.class, params);
        //如果需要添加验证，就需要用此方法
        ExcelImportResult<Employee> result = ExcelImportUtil.importExcelMore(empFile.getInputStream(), Employee.class, params);
        //这里打印出来只有员工而没有部门，所有我们需要拿部门然后再放到员工里面
        for (Employee e : result.getList()) {
            //查找出部门，放入员工中
            Department department = ds.findByName(e.getDepartment().getName());
            e.setDepartment(department);
            //给一个默认的密码,先加密
            e.setPassword(MD5Util.createMd5("123"));
            //保存
            service.merge(e);
        }
        //将错误信息打印在文档上返回
        if(result.isVerfiyFail()){
                //验证失败
                //创建一个文档，并且放回出去
                Workbook failWorkbook = result.getFailWorkbook();
                //设置返回的类型
                response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"); //mime类型
                //设置头，attachment的目的就是让浏览器不直接打开而是下载
                response.setHeader("Content-disposition", "attachment;filename=error.xlsx");
                response.setHeader("Pragma", "No-cache");//设置不要缓存
                OutputStream ouputStream = response.getOutputStream();
                failWorkbook.write(ouputStream);
                ouputStream.flush();
                ouputStream.close();
        }
        return "";
    }
}
