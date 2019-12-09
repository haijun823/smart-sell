package com.zhonghaijun.ssj.service;

import com.zhonghaijun.ssj.domain.Employee;
import com.zhonghaijun.ssj.domain.Role;

public interface RoleService extends BaseService<Role,Long> {  

    Role findRoleByEmploye(Employee employee);
}