package com.zhonghaijun.ssj.web.controller.info;

import com.zhonghaijun.ssj.common.PageDate;
import com.zhonghaijun.ssj.domain.Employee;
import com.zhonghaijun.ssj.domain.Role;
import com.zhonghaijun.ssj.query.RoleQuery;
import com.zhonghaijun.ssj.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService service;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("employees",service.findAll());
        return "info/role";
    }

    //lostinfo这是给查询出来的对象命名，解决数据丢失，在所有方法执行前会执行的方法


    //获得所有数据
    @RequestMapping("/getall")
    @ResponseBody
    public PageDate<Role> getall(RoleQuery query, String search) {
        return new PageDate<Role>(service.findPageByQuery(query));
    }

    @ModelAttribute("lostinfo")
    public Role lostInfo(Role role, String cmd) {
        if (role.getId() != null && "upd".equals(cmd)) {
            role = service.findOne(role.getId());
            //修改的时候会导致数据丢失，比如头像没有上传或者密码没有修改时
            role.getPermissions().clear();
        }
        return role;
    }

    //修改
    @RequestMapping("/upd")
    @ResponseBody
    //这是让e对象来引用上面查询出来的对象，并且在底层就对其赋值，可以让没有赋值的值有值
    public String upd(@ModelAttribute("lostinfo") Role e) {
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
    public String add(Role role) {
        service.merge(role);
        return "添加成功!!";
    }

    //根据id查找
    @RequestMapping("/getone")
    @ResponseBody
    public Role getone(Long id) {
        return service.findOne(id);
    }
}