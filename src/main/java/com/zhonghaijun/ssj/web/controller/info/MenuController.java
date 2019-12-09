package com.zhonghaijun.ssj.web.controller.info;

import com.zhonghaijun.ssj.common.PageDate;
import com.zhonghaijun.ssj.domain.Menu;
import com.zhonghaijun.ssj.query.MenuQuery;
import com.zhonghaijun.ssj.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("menu")
public class MenuController {
    
    @Autowired
    private MenuService service;

    @RequestMapping("/index")
    public String  index(){
        return "info/Menu";
    }

    //lostinfo这是给查询出来的对象命名，解决数据丢失，在所有方法执行前会执行的方法
    @ModelAttribute("lostinfo")
    public Menu lostInfo(Menu menu,String cmd){
        if (menu.getId() != null&&"upd".equals(cmd)){
            menu = service.findOne(menu.getId());
            //修改的时候会导致数据丢失，比如头像没有上传或者密码没有修改时
            return menu;
        }
        return menu;
    }
    //获得所有数据
    @RequestMapping("/getall")
    @ResponseBody
    public PageDate<Menu> getall(MenuQuery query, String search){
        return new PageDate<Menu>(service.findPageByQuery(query));
    }
    //修改
    @RequestMapping("/upd")
    @ResponseBody
    //这是让e对象来引用上面查询出来的对象，并且在底层就对其赋值，可以让没有赋值的值有值
    public String upd(@ModelAttribute("lostinfo") Menu e){
        service.merge(e);
        return "修改成功";
    }
    //删除
    @RequestMapping("/del")
    @ResponseBody
    public String del(String id){
        try {
            service.del(Long.parseLong(id));
        } catch (Exception e) {
            return "删除失败";
        }
        return "删除成功!!";
    }
    //添加
    @RequestMapping("/add")
    @ResponseBody
    public String add(Menu menu){
        service.merge(menu);
        return "添加成功!!";
    }
    //根据id查找
    @RequestMapping("/getone")
    @ResponseBody
    public Menu getone(Long id){
        return service.findOne(id);
    }
}