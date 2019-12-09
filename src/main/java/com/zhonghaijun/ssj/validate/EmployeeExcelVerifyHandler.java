package com.zhonghaijun.ssj.validate;

import cn.afterturn.easypoi.excel.entity.result.ExcelVerifyHandlerResult;
import cn.afterturn.easypoi.handler.inter.IExcelVerifyHandler;
import com.zhonghaijun.ssj.domain.Employee;
import com.zhonghaijun.ssj.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//自定义验证规则
@Component
public class EmployeeExcelVerifyHandler implements IExcelVerifyHandler<Employee> {

    //验证username是否有相同的
    @Autowired
    private EmployeeService service;

    @Override
    public ExcelVerifyHandlerResult verifyHandler(Employee employee) {
        //获取username
        ExcelVerifyHandlerResult result = new ExcelVerifyHandlerResult(true);

        if (service.findByUsername(employee.getUsername())!=null){
            result.setMsg("该用户名已经存在");
            result.setSuccess(false);
        }
        return result;
    }
}
