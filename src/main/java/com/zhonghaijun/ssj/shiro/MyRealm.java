package com.zhonghaijun.ssj.shiro;

import com.zhonghaijun.ssj.common.MD5Util;
import com.zhonghaijun.ssj.common.UserContext;
import com.zhonghaijun.ssj.domain.Employee;
import com.zhonghaijun.ssj.domain.Permission;
import com.zhonghaijun.ssj.domain.Role;
import com.zhonghaijun.ssj.service.EmployeeService;
import com.zhonghaijun.ssj.service.PermissionService;
import com.zhonghaijun.ssj.service.RoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    //只要是交给spring管理的对象，不需要扫描包都能自动注入
    @Autowired
    private EmployeeService service;
    @Autowired
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //从数据库种查询出对应的权限
        Set<String> set = permissionService.findPermissionsByEmployee(UserContext.getEmployee());
        // 将权限设置进授权对象中
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(set);
        return info;
    }



    //进行登陆验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获得传入进来的账号密码
        String username = (String)authenticationToken.getPrincipal();
        //通过账号来查找用户
        Employee employee = service.findByUsername(username);
        if (employee == null){
            return null;
        }
        //密码加密
        ByteSource source = ByteSource.Util.bytes(MD5Util.SALT);
        return new SimpleAuthenticationInfo(employee,employee.getPassword(),source,getName());
    }

}
