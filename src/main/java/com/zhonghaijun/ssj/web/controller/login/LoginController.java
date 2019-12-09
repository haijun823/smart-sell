package com.zhonghaijun.ssj.web.controller.login;

import com.baidu.aip.face.AipFace;
import com.zhonghaijun.ssj.common.AjaxResult;
import com.zhonghaijun.ssj.common.CookieUtil;
import com.zhonghaijun.ssj.common.UserContext;
import com.zhonghaijun.ssj.common.UserImage;
import com.zhonghaijun.ssj.common.facelogin.AiFaceObject;
import com.zhonghaijun.ssj.common.facelogin.FaceDetection;
import com.zhonghaijun.ssj.common.facelogin.FaceRegistration;
import com.zhonghaijun.ssj.common.facelogin.FaceUser;
import com.zhonghaijun.ssj.domain.Employee;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class LoginController {


    private HttpServletRequest request;
    private HttpServletResponse response;

    //跳转上传文件页面
    @RequestMapping("/upload")
    public String upload(){
        return "info/upload";
    }


    //跳转登陆页面
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpServletRequest request){
        //获得cookies
        Cookie[] cookies = request.getCookies();
        // 长度不能等于1 因为会存在一个jessxxx的默认cookie
        if (cookies != null&&cookies.length!=1) {
            //调用验证方法，并且返回对应的路径
            String path = autoLogin(cookies);
            return path;
        }
        return "login/index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult login(HttpServletRequest request,HttpServletResponse response){
        //取出账号和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //是否记住密码
        String isRemember = request.getParameter("isRemember");
        if ("y".equals(isRemember)){
            //创建cookie
            CookieUtil.getCookie(request, response);
        }
        //获取用户
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            try{
                //根据toke完成登录功能,自动调用MyRealm
                subject.login(token);
            }catch (UnknownAccountException e){
                return new AjaxResult("false","账号不存在");
            }catch (IncorrectCredentialsException e){
                return new AjaxResult("false","密码错误");
            }catch (AuthenticationException e){
                return new AjaxResult("false","网络错误");
            }
        }
        //在登陆成功时，将用户装进域对象中
        Employee employee = (Employee) subject.getPrincipal();
        UserContext.setEmployee(employee);
        return new AjaxResult("succuss","登陆成功");
    }

    //验证的方法
    public static String autoLogin(Cookie[] cookies){
        String cookie_username = "";
        String cookie_password = "";
        //遍历cookies
        for (Cookie cookie : cookies) {
            //将cookie中的值存入
            if("cookie_username".equals(cookie.getName())){
                cookie_username = cookie.getValue();
            }else if ("cookie_password".equals(cookie.getName())){
                cookie_password = cookie.getValue();
            }
        }
        //当账号密码都不会空的时候，进行验证
        Subject subject = SecurityUtils.getSubject();
        if (!cookie_username.equals("") && !cookie_password.equals("")){
            if (!subject.isAuthenticated()){
                UsernamePasswordToken token = new UsernamePasswordToken(cookie_username, cookie_password);
                subject.login(token);
            }
        }else {
            return "/login/index";
        }
        //将对象装进域对象中,可以获得授权
        UserContext.setEmployee((Employee)subject.getPrincipal());
        return "forward:/main/index";
    }

    //清除cookie，不需要自动登陆
    @RequestMapping("/cookielogout")
    public String cancelAutoLogin(HttpServletRequest request,HttpServletResponse response){
        CookieUtil.removeCookie(request, response);
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie);
        }
        return "redirect:/logout";
    }


    //没有权限时跳转的页面
    @RequestMapping("/unauthorized")
    public String unauthorizad(){
        return "/login/unauthorizedUrl";
    }
    //人脸登陆
    @RequestMapping("/face")
    public String face(){
        return "/login/facelogin";
    }
    @RequestMapping("/faceCkecked")
    @ResponseBody
    public String faceCkecked(UserImage userImage,HttpServletRequest request) throws Exception {
        String s = faceLogin(userImage, request);
        return s;
    }
    @RequestMapping("/faceRegist")
    @ResponseBody
    public String faceRegist(UserImage userImage) throws Exception {
        return faceRegist2(userImage);
    }

    public static String faceLogin(UserImage user,HttpServletRequest request) throws Exception {
        AipFace client = AiFaceObject.getClient();
        //检测是否合格
        JSONObject s = FaceDetection.Facedetection(client, user);
        //检测上传的图片是否符合要求
        if ("SUCCESS".equals(s.get("error_msg"))){
            //检测是否有用户,并且对比
            String result = FaceUser.Faceuser(client, user);
            Subject subject = SecurityUtils.getSubject();
            if (!subject.isAuthenticated()){
                UsernamePasswordToken token = new UsernamePasswordToken("admin","123");
                subject.login(token);
                Employee employee = (Employee) subject.getPrincipal();
                UserContext.setEmployee(employee);
            }
            return result;
        }
        return s.toString();
    }
    //人脸注册
    public static String faceRegist2(UserImage image) throws Exception {
        AipFace client = AiFaceObject.getClient();
        //调用人脸注册的方法
        String result = FaceRegistration.Faceregistrtion(client, "user", "1",image);
        return result;
    }





}
