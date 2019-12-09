package com.zhonghaijun.ssj.service.shiro;

import com.zhonghaijun.ssj.domain.Employee;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm extends AuthorizingRealm {

    /**
     * 认证，权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 授权,身份认证，登陆
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        Employee employee = new Employee();
        employee.setUsername("admin");
        employee.setPassword("123456");

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo("admin", "12345", getName());

        return info;
    }

    //获取到realm的名称
    public String getName(){
        return "MyRealm";
    }
}
