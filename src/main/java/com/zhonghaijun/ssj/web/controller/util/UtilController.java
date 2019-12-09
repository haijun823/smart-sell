package com.zhonghaijun.ssj.web.controller.util;

import com.zhonghaijun.ssj.domain.Employee;
import com.zhonghaijun.ssj.domain.Product;
import com.zhonghaijun.ssj.service.EmployeeService;
import com.zhonghaijun.ssj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/util")
public class UtilController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ProductService productService;

    //获得所有的采购员
    @RequestMapping("/findAllBuyer")
    @ResponseBody
    public List<Employee> getBuyer(){
        return employeeService.findAllBuyer("采购部");
    }
    @RequestMapping("/findAllProduct")
    @ResponseBody
    public List<Product> findAllProduct(){
        return productService.findAll();
    }

}
