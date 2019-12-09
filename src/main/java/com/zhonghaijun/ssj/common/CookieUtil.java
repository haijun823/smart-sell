package com.zhonghaijun.ssj.common;

import com.zhonghaijun.ssj.domain.Employee;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CookieUtil {
    /**
     * 创建cookie
     * @param request
     * @param response
     */
    //设置清除cookie的路径
    private static final String PATH = "/";

    public static void getCookie(HttpServletRequest request, HttpServletResponse response){

        //设置账号
        Cookie u = new Cookie("cookie_username",request.getParameter("username"));
        Cookie p = new Cookie("cookie_password", request.getParameter("password"));
        //设置生命周期
        u.setMaxAge(60*60);
        u.setPath(PATH);
        p.setMaxAge(60*60);
        p.setPath(PATH);
        //添加
        response.addCookie(u);
        response.addCookie(p);
    }
    //销毁cookie
    public static void removeCookie(HttpServletRequest request,HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            //设置所有路径下的cookie
            cookie.setPath(PATH);
            response.addCookie(cookie);
        }
    }
}
