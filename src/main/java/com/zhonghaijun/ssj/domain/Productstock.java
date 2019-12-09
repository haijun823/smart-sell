package com.zhonghaijun.ssj.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "productstock")
public class Productstock extends BaseDomain {

    //数量
    private BigDecimal num;
    //当前仓库产品的小计
    private BigDecimal amount;
    //当前产品的价格
    private BigDecimal price;
    //入库时间
    private Date incomedate;
    //库存预警,库存过多，过少自动发出预警
    private Boolean warning = true;
    //最大库存量
    private BigDecimal topnum = new BigDecimal("100");
    //最低库存量
    private BigDecimal bottomnum = new BigDecimal("50");

    //产品
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    //仓库
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "depot_id")
    private Depot depot;



    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getIncomedate() {
        return incomedate;
    }

    public void setIncomedate(Date incomedate) {
        this.incomedate = incomedate;
    }

    public Boolean getWarning() {
        return warning;
    }

    public void setWarning(Boolean warning) {
        this.warning = warning;
    }

    public BigDecimal getTopnum() {
        return topnum;
    }

    public void setTopnum(BigDecimal topnum) {
        this.topnum = topnum;
    }

    public BigDecimal getBottomnum() {
        return bottomnum;
    }

    public void setBottomnum(BigDecimal bottomnum) {
        this.bottomnum = bottomnum;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }
}