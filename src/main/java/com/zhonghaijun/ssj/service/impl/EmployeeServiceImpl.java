package com.zhonghaijun.ssj.service.impl;

import com.zhonghaijun.ssj.domain.Employee;
import com.zhonghaijun.ssj.repository.EmployeeRepository;
import com.zhonghaijun.ssj.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee,Long> implements EmployeeService {

    //注入Employee接口
    @Autowired
    private EmployeeRepository repository;

    /**
     * 检查用户名是否重复
     * @param username
     * @return
     */
    @Override
    public Boolean checkName(String username,Long id) {
        Employee employees = repository.findByUsername(username);
        if (id != null){
            Employee one = repository.findOne(id);
            if (one.getUsername().equals(username)||employees !=null){
                return true;
            }else {
                return false;
            }
        }else {
            return employees==null?true:false;
        }

    }

    @Override
    public Employee findByUsername(String usernmae) {
        return repository.findByUsername(usernmae);
    }

    @Override
    public List<Employee> findAllBuyer(String dpetName) {
        return repository.findAllBuyer(dpetName);
    }
}
