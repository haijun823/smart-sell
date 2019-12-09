package com.zhonghaijun.ssj.service;

import com.zhonghaijun.ssj.domain.Department;

import java.util.List;

public interface DepartmentService extends BaseService<Department,Long> {

    List<Department> getAll();

    //通过名字来查找部门
    Department findByName(String name);

}
