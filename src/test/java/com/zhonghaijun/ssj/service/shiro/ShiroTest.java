package com.zhonghaijun.ssj.service.shiro;


import com.zhonghaijun.ssj.repository.BaseTest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class ShiroTest extends BaseTest {

    @Test
    public void test(){
        //创建自己的realm
        MyRealm realm = new MyRealm();

        //创建权限管理器
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        //将自己定义的ealm放进权限管理器中
        securityManager.setRealm(realm);
        //将realm放进securityManager中,将权限管理器放到相应的环境中去，在任何地方都能得到
        SecurityUtils.setSecurityManager(securityManager);
        //获得当前用户
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.getPrincipal());
        //准备登陆的令牌，token是前端传过来
        UsernamePasswordToken token = new UsernamePasswordToken("admin", "123456");
        //根据令牌来判断权限
        try {
            securityManager.login(subject, token);
        } catch (UnknownAccountException e) {
            System.out.println("没有当前账号");
        } catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
        }

    }
}
