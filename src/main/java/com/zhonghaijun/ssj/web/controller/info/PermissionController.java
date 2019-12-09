package com.zhonghaijun.ssj.web.controller.info;

import com.zhonghaijun.ssj.common.PageDate;
import com.zhonghaijun.ssj.domain.Employee;
import com.zhonghaijun.ssj.domain.Permission;
import com.zhonghaijun.ssj.query.PermissionQuery;
import com.zhonghaijun.ssj.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("permission")
public class PermissionController {

    @Autowired
    private PermissionService service;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("employees",service.findAll());
        return "info/permission";
    }

    //lostinfo这是给查询出来的对象命名，解决数据丢失，在所有方法执行前会执行的方法
    @ModelAttribute("lostinfo")
    public Permission lostInfo(Permission permission, String cmd) {
        if (permission.getId() != null && "upd".equals(cmd)) {
            permission = service.findOne(permission.getId());
            //修改的时候会导致数据丢失，比如头像没有上传或者密码没有修改时
            return permission;
        }
        return permission;
    }

    //获得所有数据
    @RequestMapping("/getall")
    @ResponseBody
    public PageDate<Permission> getall(PermissionQuery query,String search) {
        return new PageDate<Permission>(service.findPageByQuery(query));
    }

    //修改
    @RequestMapping("/upd")
    @ResponseBody
    //这是让e对象来引用上面查询出来的对象，并且在底层就对其赋值，可以让没有赋值的值有值
    public String upd(@ModelAttribute("lostinfo") Permission e) {
        service.merge(e);
        return "修改成功";
    }

    //删除
    @RequestMapping("/del")
    @ResponseBody
    public String del(String id) {
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
    public String add(Permission permission) {
        service.merge(permission);
        return "添加成功!!";
    }

    //根据id查找
    @RequestMapping("/getone")
    @ResponseBody
    public Permission getone(Long id) {
        return service.findOne(id);
    }
}