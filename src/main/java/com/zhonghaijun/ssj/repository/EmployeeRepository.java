package com.zhonghaijun.ssj.repository;

import com.zhonghaijun.ssj.domain.Employee;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends BaseRepository<Employee,Long> {

    //检查用户名是否重复
    Employee findByUsername(String username);

    //查找所有的采购员
    @Query("select e from Employee e where e.department.name = ?1")
    List<Employee> findAllBuyer(String deptName);
}
