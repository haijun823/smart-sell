package com.zhonghaijun.ssj.service.impl;

import com.zhonghaijun.ssj.domain.Employee;
import com.zhonghaijun.ssj.domain.Role;
import com.zhonghaijun.ssj.repository.RoleRepository;
import com.zhonghaijun.ssj.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role,Long> implements RoleService {
    @Autowired
    private RoleRepository repository;


    @Override
    public Role findRoleByEmploye(Employee employee) {
        return repository.findRoleByEmployee(employee);
    }
}