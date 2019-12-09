package com.zhonghaijun.ssj.service;

import com.zhonghaijun.ssj.domain.Employee;

import java.util.List;

public interface EmployeeService extends BaseService<Employee,Long> {

    //检查用户名是否重复
    Boolean checkName(String username,Long id);

    //通过用户名查找对象
    Employee findByUsername(String usernmae);

    //查找所有的采购员
    List<Employee> findAllBuyer(String dpetName);
}
