package com.zhonghaijun.ssj.repository;

import com.zhonghaijun.ssj.domain.Employee;
import com.zhonghaijun.ssj.domain.Role;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends BaseRepository<Role,Long> {

    //通过用工查找角色
    @Query("select er from Employee e join e.roles er where e=?1")
    Role findRoleByEmployee(Employee employee);
}