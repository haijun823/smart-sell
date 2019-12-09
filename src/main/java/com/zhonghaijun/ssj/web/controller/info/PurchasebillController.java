package com.zhonghaijun.ssj.web.controller.info;

import com.zhonghaijun.ssj.common.UserContext;
import com.zhonghaijun.ssj.domain.*;
import com.zhonghaijun.ssj.query.PurchasebillQuery;
import com.zhonghaijun.ssj.service.PurchasebillService;
import com.zhonghaijun.ssj.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;


@Controller
@RequestMapping("purchasebill")
public class PurchasebillController {

    @Autowired
    private PurchasebillService service;

    @RequestMapping("/index")
    public String index() {
        return "info/purchasebill";
    }

    //lostinfo这是给查询出来的对象命名，解决数据丢失，在所有方法执行前会执行的方法
    @ModelAttribute("lostinfo")
    public Purchasebill lostInfo(Purchasebill purchasebill, String cmd) {
        if (purchasebill.getId() != null && "upd".equals(cmd)) {
            purchasebill = service.findOne(purchasebill.getId());
            //修改的时候会导致数据丢失，比如头像没有上传或者密码没有修改时
            purchasebill.setSupplier(null);
            purchasebill.setBuyer(null);
            purchasebill.getItems().clear();
        }
        return purchasebill;
    }

    @Autowired
    private RoleService roleService;
    //获得所有数据
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Purchasebill> findAll(PurchasebillQuery query) {
        if (SecurityUtils.getSubject().hasRole("超级管理员")){
            return service.findAllByPosition();
        }
        return service.findAllByQuery(query);
    }

    //修改
    @RequestMapping("/upd")
    @ResponseBody
    //这是让e对象来引用上面查询出来的对象，并且在底层就对其赋值，可以让没有赋值的值有值
    public String upd(@ModelAttribute("lostinfo") Purchasebill purchasebill) {
        addOrSave(purchasebill);
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
    public String add(Purchasebill purchasebill) {
        Employee employee = UserContext.getEmployee();
        purchasebill.setInputUser(employee);
        addOrSave(purchasebill);
        return "添加成功!!";
    }

    //根据id查找
    @RequestMapping("/getone")
    @ResponseBody
    public Purchasebill getone(Long id) {
        return service.findOne(id);
    }
    //添加和修改的方法
    public void addOrSave(Purchasebill purchasebill){
        BigDecimal totalAmount = new BigDecimal("0");
        BigDecimal totalNum = new BigDecimal("0");
        List<Purchasebillitem> items = purchasebill.getItems();
        for (Purchasebillitem item : items) {
            //多方跟一方建立关系
            item.setBill(purchasebill);
            //计算明细
            item.setAmount(item.getNum().multiply(item.getPrice()));
            totalAmount = totalAmount.add(item.getAmount());
            totalNum = totalNum.add(item.getAmount());
        }
        purchasebill.setTotalamount(totalAmount);
        purchasebill.setTotalnum(totalNum);
        service.merge(purchasebill);
    }
}