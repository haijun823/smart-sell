package com.zhonghaijun.ssj.service.impl;

import com.zhonghaijun.ssj.domain.Department;
import com.zhonghaijun.ssj.domain.Employee;
import com.zhonghaijun.ssj.repository.DepartmenRepository;
import com.zhonghaijun.ssj.service.DepartmentService;
import com.zhonghaijun.ssj.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl extends BaseServiceImpl<Department,Long> implements DepartmentService {

    @Autowired
    private DepartmenRepository repository;

    @Override
    public List<Department> getAll() {
        return repository.findAll();
    }

    @Override
    public Department findByName(String name) {
        return repository.findByName(name);
    }

}
