package com.zhonghaijun.ssj.web.controller.info;

import com.zhonghaijun.ssj.domain.Systemdictionarydetail;
import com.zhonghaijun.ssj.domain.Systemdictionarytype;
import com.zhonghaijun.ssj.query.SystemdictionarydetailQuery;
import com.zhonghaijun.ssj.service.SystemdictionarydetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("systemdictionarydetail")
public class SystemdictionarydetailController {
    
    @Autowired
    private SystemdictionarydetailService service;

    @RequestMapping("/index")
    public String  index(){
        return "info/systemdictionarydetail";
    }

    //lostinfo这是给查询出来的对象命名，解决数据丢失，在所有方法执行前会执行的方法
    @ModelAttribute("lostinfo")
    public Systemdictionarydetail lostInfo(Systemdictionarydetail systemdictionarydetail,String cmd){
        if (systemdictionarydetail.getId() != null&&"upd".equals(cmd)){
            systemdictionarydetail = service.findOne(systemdictionarydetail.getId());
            //修改的时候会导致数据丢失，比如头像没有上传或者密码没有修改时
            systemdictionarydetail.setTypes(null);
        }
        return systemdictionarydetail;
    }
    //获得所有数据
    @RequestMapping("/getall")
    @ResponseBody
    public List<Systemdictionarydetail> getall(SystemdictionarydetailQuery query){
        return service.findAllByQuery(query);
    }
    //通过后缀
    @RequestMapping("/getunit")
    @ResponseBody
    public List<Systemdictionarydetail> findUnit(){
        return service.findDetailsBySn(Systemdictionarytype.UNIT);
    }
    @RequestMapping("/getbrand")
    @ResponseBody
    public List<Systemdictionarydetail> findBrand(){
        return service.findDetailsBySn(Systemdictionarytype.BRAND);
    }

    //修改
    @RequestMapping("/upd")
    @ResponseBody
    //这是让e对象来引用上面查询出来的对象，并且在底层就对其赋值，可以让没有赋值的值有值
    public String upd(@ModelAttribute("lostinfo") Systemdictionarydetail e){
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
    public String add(Systemdictionarydetail systemdictionarydetail){
        service.merge(systemdictionarydetail);
        return "添加成功!!";
    }
    //根据id查找
    @RequestMapping("/findOne")
    @ResponseBody
    public Systemdictionarydetail findOne(Long id){
        return service.findOne(id);
    }
}