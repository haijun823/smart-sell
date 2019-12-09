package com.zhonghaijun.ssj.repository;


import com.zhonghaijun.ssj.domain.Employee;
import com.zhonghaijun.ssj.domain.Position;
import com.zhonghaijun.ssj.domain.Purchasebill;
import com.zhonghaijun.ssj.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BaseTest2 {

    @Autowired
    private PurchasebillRepository purchasebillRepository;

    @Test
    @Transactional
    public void test(){
        Position position = new Position();
        position.setId(1L);
        List<Purchasebill> list = purchasebillRepository.findAllByPosition(position);
        for (Purchasebill purchasebill : list) {
            System.out.println(purchasebill);
        }
    }

    @Autowired
    private RoleRepository roleRepository;

    @Test
    @Transactional
    public void test2(){
        Employee employee = new Employee();
        employee.setId(1L);
        Role roleByEmployeeId = roleRepository.findRoleByEmployee(employee);
        System.out.println(roleByEmployeeId);
    }


}
