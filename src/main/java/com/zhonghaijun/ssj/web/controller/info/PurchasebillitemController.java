package com.zhonghaijun.ssj.web.controller.info;

import com.zhonghaijun.ssj.common.PageDate;
import com.zhonghaijun.ssj.domain.PerchaseBillItemVo;
import com.zhonghaijun.ssj.domain.Purchasebillitem;
import com.zhonghaijun.ssj.query.PurchasebillitemQuery;
import com.zhonghaijun.ssj.service.PurchasebillitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/purchasebillitem")
public class PurchasebillitemController {
    
    @Autowired
    private PurchasebillitemService service;

    @RequestMapping("/index")
    public String  index(){
        return "info/purchasebillitem";
    }

    //lostinfo这是给查询出来的对象命名，解决数据丢失，在所有方法执行前会执行的方法
    @ModelAttribute("lostinfo")
    public Purchasebillitem lostInfo(Purchasebillitem purchasebillitem,String cmd){
        if (purchasebillitem.getId() != null&&"upd".equals(cmd)){
            purchasebillitem = service.findOne(purchasebillitem.getId());
            //修改的时候会导致数据丢失，比如头像没有上传或者密码没有修改时
            return purchasebillitem;
        }
        return purchasebillitem;
    }

    //查找items
    @RequestMapping("/findItems")
    @ResponseBody
    public List<Map<String,Object>> findItems(PurchasebillitemQuery query){
        return service.findGroupByQuery(query);
    }



    //获得所有数据
    @RequestMapping("/findAll")
    @ResponseBody
    public List<PerchaseBillItemVo> getall(PurchasebillitemQuery query, String search){
        return service.findItems(query);
    }
    //修改
    @RequestMapping("/upd")
    @ResponseBody
    //这是让e对象来引用上面查询出来的对象，并且在底层就对其赋值，可以让没有赋值的值有值
    public String upd(@ModelAttribute("lostinfo") Purchasebillitem e){
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
    public String add(Purchasebillitem purchasebillitem){
        service.merge(purchasebillitem);
        return "添加成功!!";
    }
    //根据id查找
    @RequestMapping("/findOne")
    @ResponseBody
    public Purchasebillitem findOne(Long id){
        return service.findOne(id);
    }
}