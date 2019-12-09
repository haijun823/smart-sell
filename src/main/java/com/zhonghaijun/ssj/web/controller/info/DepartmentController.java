package com.zhonghaijun.ssj.web.controller.info;

import com.zhonghaijun.ssj.domain.Department;
import com.zhonghaijun.ssj.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @RequestMapping("/getdept")
    @ResponseBody
    public List<Department> getDept(){
        return service.getAll();
    }
    @RequestMapping("/index")
    public String jump(){
        return "info/employee";
    }

}
