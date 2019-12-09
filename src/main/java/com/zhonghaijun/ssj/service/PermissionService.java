package com.zhonghaijun.ssj.service;

import com.zhonghaijun.ssj.domain.Employee;
import com.zhonghaijun.ssj.domain.Permission;
import com.zhonghaijun.ssj.domain.Role;

import java.util.List;
import java.util.Set;

public interface PermissionService extends BaseService<Permission,Long> {

    Set<String> findPermissionsByEmployee(Employee employee);
}