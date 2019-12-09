package com.zhonghaijun.ssj.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "stockincomebill")
public class Stockincomebill extends BaseDomain {


    private Date vdate;
    private BigDecimal totalamount;
    private BigDecimal totalnum;
    //录入时间，直接自动生成
    private Date inputtime = new Date();
    private Date auditortime;
    //默认状态
    private Integer status = 0;

    //供应商
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    //审核的人员
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auditor_id")
    private Employee auditor;

    //录入人员
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "inputuser_id")
    private Employee inputuser;

    //仓库保管员
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "keeper_id")
    private Employee keeper;

    //仓库
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "depot_id")
    private Depot depot;


    //一个入库清淡，包含多个详细表
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Stockincomebillitem> items = new ArrayList<>();


    public List<Stockincomebillitem> getItems() {
        return items;
    }

    public void setItems(List<Stockincomebillitem> items) {
        this.items = items;
    }

    public Date getVdate() {
        return vdate;
    }

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

    public Employee getInputuser() {
        return inputuser;
    }

    public void setInputuser(Employee inputuser) {
        this.inputuser = inputuser;
    }

    public Employee getKeeper() {
        return keeper;
    }

    public void setKeeper(Employee keeper) {
        this.keeper = keeper;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }
}