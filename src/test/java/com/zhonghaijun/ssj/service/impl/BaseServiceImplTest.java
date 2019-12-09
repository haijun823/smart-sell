package com.zhonghaijun.ssj.service.impl;

import com.zhonghaijun.ssj.domain.*;
import com.zhonghaijun.ssj.query.BaseQuery;
import com.zhonghaijun.ssj.query.EmployeeQuery;
import com.zhonghaijun.ssj.repository.BaseTest;
import com.zhonghaijun.ssj.service.EmployeeService;
import com.zhonghaijun.ssj.service.RoleService;
import com.zhonghaijun.ssj.service.StockincomebillService;
import com.zhonghaijun.ssj.service.SystemdictionarydetailService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.mail.MailMessage;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.management.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class BaseServiceImplTest extends BaseTest {

    @Autowired
    private StockincomebillService stockincomebillService;


    @Test
    public void getAll() {
        Stockincomebill bill = new Stockincomebill();
        bill.setDepot(new Depot(1L));
        bill.setInputuser(new Employee(1L));
        bill.setKeeper(new Employee(2L));
        bill.setSupplier(new Supplier(2L));
        bill.setVdate(new Date());


        List<Stockincomebillitem> items = new ArrayList<Stockincomebillitem>();
        Stockincomebillitem billItem = new Stockincomebillitem();
        billItem.setDescs("备注1");
        billItem.setNum(new BigDecimal(1));
        billItem.setPrice(new BigDecimal(1));
        billItem.setProduct(new Product(1L));
        items.add(billItem);

        Stockincomebillitem billItem2 = new Stockincomebillitem();
        billItem2.setDescs("备注2");
        billItem2.setNum(new BigDecimal(2));
        billItem2.setPrice(new BigDecimal(2));
        billItem2.setProduct(new Product(2L));
        items.add(billItem2);

        BigDecimal totalAmount = new BigDecimal(0);// 总金额
        BigDecimal totalNum = new BigDecimal(0);// 总数量

        for (Stockincomebillitem item : items) {
            // 设置多方到一方的关系
            item.setBill(bill);
            // 计算小计
            item.setAmount(item.getPrice().multiply(item.getNum()));
            // 累加
            totalAmount = totalAmount.add(item.getAmount());
            totalNum = totalNum.add(item.getNum());
        }
        // 设置总金额,总数量
        bill.setTotalamount(totalAmount);
        bill.setTotalnum(totalNum);

        // 设置一方到多方的关系
        bill.setItems(items);

        // 级联保存
        stockincomebillService.merge(bill);

    }
    @Autowired
    private JavaMailSender mailSender;
    @Test
    public void sendEmail() throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("1424132610@qq.com");
        helper.setSubject("主题：信用卡");
        helper.setText("牛逼的大学");
        helper.setTo("1425275978@qq.com");
        mailSender.send(message);
    }

}