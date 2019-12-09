package com.zhonghaijun.ssj.service.impl;

import com.zhonghaijun.ssj.domain.Employee;
import com.zhonghaijun.ssj.domain.Permission;
import com.zhonghaijun.ssj.domain.Role;
import com.zhonghaijun.ssj.repository.PermissionRepository;
import com.zhonghaijun.ssj.service.PermissionService;
import com.zhonghaijun.ssj.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission,Long> implements PermissionService {
    @Autowired
    private PermissionRepository repository;




    @Override
    public Set<String> findPermissionsByEmployee(Employee employee) {
        return repository.findPermissionsByEmployee(employee);
    }
}