package com.zhonghaijun.ssj.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "purchasebill")
public class Purchasebill extends BaseDomain {


    private Date vdate;
    //总金额
    private BigDecimal totalamount;
    //总数
    private BigDecimal totalnum;
    //录入时间
    private Date inputtime = new Date();
    //审核时间
    private Date auditortime;
    //状态
    private Integer status = 0;

    //供应商
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    //审核的人
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auditor_id")
    private Employee auditor;

    //输入的人
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "inputuser_id")
    private Employee inputUser;

    //采购者
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "buyer_id")
    private Employee buyer;

    //一对多，需要一方放弃维护，交给多方的字段来维护，级联删除，一个可以删除多方
    @OneToMany(mappedBy = "bill",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Purchasebillitem> items = new ArrayList<>();

    //返回json格式需要对应的时间格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getVdate() {
        return vdate;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setVdate(Date vdate) {
        this.vdate = vdate;
    }

    public BigDecimal getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(BigDecimal totalamount) {
        this.totalamount = totalamount;
    }

    public BigDecimal getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(BigDecimal totalnum) {
        this.totalnum = totalnum;
    }

    public Date getInputtime() {
        return inputtime;
    }

    public void setInputtime(Date inputtime) {
        this.inputtime = inputtime;
    }

    public Date getAuditortime() {
        return auditortime;
    }

    public void setAuditortime(Date auditortime) {
        this.auditortime = auditortime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Employee getAuditor() {
        return auditor;
    }

    public void setAuditor(Employee auditor) {
        this.auditor = auditor;
    }

    public Employee getInputUser() {
        return inputUser;
    }

    public void setInputUser(Employee inputUser) {
        this.inputUser = inputUser;
    }

    public Employee getBuyer() {
        return buyer;
    }

    public void setBuyer(Employee buyer) {
        this.buyer = buyer;
    }

    public List<Purchasebillitem> getItems() {
        return items;
    }

    public void setItems(List<Purchasebillitem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Purchasebill{" +
                "vdate=" + vdate +
                ", totalamount=" + totalamount +
                ", totalnum=" + totalnum +
                ", inputtime=" + inputtime +
                ", auditortime=" + auditortime +
                ", status=" + status +
                '}';
    }
}