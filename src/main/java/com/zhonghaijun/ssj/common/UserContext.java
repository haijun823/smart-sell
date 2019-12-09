package com.zhonghaijun.ssj.common;

import com.zhonghaijun.ssj.domain.Employee;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * 存放用户
 */
public class UserContext {

    private static final String USER_INFO = "LoginUser";

    //设置进域对象中
    public static void setEmployee(Employee loginuser){
        //获得当前账号
        Subject subject = SecurityUtils.getSubject();
        //将当前账号装进域对象中
        subject.getSession().setAttribute(USER_INFO, loginuser);

    }
    public static Employee getEmployee(){
        //获得当前账号
        Subject subject = SecurityUtils.getSubject();
        //从域对象中取出employee对象
        Employee employee = (Employee) subject.getSession().getAttribute(USER_INFO);
        return employee;

    }

}
