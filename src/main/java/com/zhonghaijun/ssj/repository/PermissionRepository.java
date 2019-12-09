package com.zhonghaijun.ssj.repository;

import com.zhonghaijun.ssj.domain.Employee;
import com.zhonghaijun.ssj.domain.Permission;
import com.zhonghaijun.ssj.domain.Role;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface PermissionRepository extends BaseRepository<Permission,Long> {

    @Query("select distinct p.sn from Employee e join e.roles r join r.permissions p where e=?1")
    Set<String> findPermissionsByEmployee(Employee employee);
}