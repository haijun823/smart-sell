package com.zhonghaijun.ssj.web.controller.info;

import com.zhonghaijun.ssj.domain.Systemdictionarytype;
import com.zhonghaijun.ssj.query.SystemdictionarytypeQuery;
import com.zhonghaijun.ssj.service.SystemdictionarytypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("systemdictionarytype")
public class SystemdictionarytypeController {
    
    @Autowired
    private SystemdictionarytypeService service;

    @RequestMapping("/index")
    public String  index(){
        return "info/systemdictionarytype";
    }

    //lostinfo这是给查询出来的对象命名，解决数据丢失，在所有方法执行前会执行的方法
    @ModelAttribute("lostinfo")
    public Systemdictionarytype lostInfo(Systemdictionarytype systemdictionarytype,String cmd){
        if (systemdictionarytype.getId() != null&&"upd".equals(cmd)){
            systemdictionarytype = service.findOne(systemdictionarytype.getId());
            //修改的时候会导致数据丢失，比如头像没有上传或者密码没有修改时
            return systemdictionarytype;
        }
        return systemdictionarytype;
    }
    //获得所有数据
    @RequestMapping("/getall")
    @ResponseBody
    public List<Systemdictionarytype> getall(SystemdictionarytypeQuery query, String search){
        return service.findAllByQuery(query);
    }
    //修改
    @RequestMapping("/upd")
    @ResponseBody
    //这是让e对象来引用上面查询出来的对象，并且在底层就对其赋值，可以让没有赋值的值有值
    public String upd(@ModelAttribute("lostinfo") Systemdictionarytype e){
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
    public String add(Systemdictionarytype systemdictionarytype){
        service.merge(systemdictionarytype);
        return "添加成功!!";
    }
    //根据id查找
    @RequestMapping("/findOne")
    @ResponseBody
    public Systemdictionarytype findOne(Long id){
        return service.findOne(id);
    }
}