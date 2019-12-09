package com.zhonghaijun.ssj.web.controller.main;

import com.zhonghaijun.ssj.common.UserContext;
import com.zhonghaijun.ssj.domain.Menu;
import com.zhonghaijun.ssj.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {
    @Autowired
    private MenuService service;

    @RequestMapping("/index")
    public String index() {
        return "main/main";
    }

    //根据用户来获得菜单
    @RequestMapping("/menus")
    @ResponseBody
    public List<Menu> getMenus(){
        return service.findMenus(UserContext.getEmployee().getId());
    }


    @RequestMapping("/talk")
    public String test(){
        return "main/talk";
    }

}
