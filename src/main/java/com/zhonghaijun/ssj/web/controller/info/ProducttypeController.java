package com.zhonghaijun.ssj.web.controller.info;

import com.zhonghaijun.ssj.domain.Producttype;
import com.zhonghaijun.ssj.query.ProducttypeQuery;
import com.zhonghaijun.ssj.service.ProducttypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("producttype")
public class ProducttypeController {
    
    @Autowired
    private ProducttypeService service;

    @RequestMapping("/index")
    public String  index(){
        return "info/producttype";
    }

    //lostinfo这是给查询出来的对象命名，解决数据丢失，在所有方法执行前会执行的方法
    @ModelAttribute("lostinfo")
    public Producttype lostInfo(Producttype producttype,String cmd){
        if (producttype.getId() != null&&"upd".equals(cmd)){
            producttype = service.findOne(producttype.getId());
            //修改的时候会导致数据丢失，比如头像没有上传或者密码没有修改时
            return producttype;
        }
        return producttype;
    }
    //获得所有数据
    @RequestMapping("/getall")
    @ResponseBody
    public List<Producttype> getall(ProducttypeQuery query){
        return service.findAllByQuery(query);
    }
    @RequestMapping("/getchildren")
    @ResponseBody
    public List<Producttype> getChildren(){
        return service.findChildren();
    }

    @RequestMapping("/getparent")
    @ResponseBody
    public List<Producttype> getParent(){
        return service.findParent();
    }

    //修改
    @RequestMapping("/upd")
    @ResponseBody
    //这是让e对象来引用上面查询出来的对象，并且在底层就对其赋值，可以让没有赋值的值有值
    public String upd(@ModelAttribute("lostinfo") Producttype e){
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
    public String add(Producttype producttype){
        service.merge(producttype);
        return "添加成功!!";
    }
    //根据id查找
    @RequestMapping("/findOne")
    @ResponseBody
    public Producttype findOne(Long id){
        return service.findOne(id);
    }
}