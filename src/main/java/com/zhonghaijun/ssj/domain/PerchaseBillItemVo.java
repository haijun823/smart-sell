package com.zhonghaijun.ssj.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.time.DateUtils;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

//报表明细
public class PerchaseBillItemVo {

    private Long id; //编号
    private String supplier; //供应商名称
    private String buyer; //采购员名称
    private String product; //产品名称
    private String productType; //产品分类
    private Date vdate; //交易时间
    private BigDecimal num; //采购数量
    private BigDecimal price; //价格
    private BigDecimal amount; //小计 = 价格*数量
    private Integer status;

    private String groupField = ""; //分组字段


    public PerchaseBillItemVo(Purchasebillitem purchasebillitem,String groupBy) {
        this.id = purchasebillitem.getId();
        this.supplier = purchasebillitem.getBill().getSupplier().getName();
        this.buyer = purchasebillitem.getBill().getBuyer().getName();
        this.product = purchasebillitem.getProduct().getName();
        this.productType = purchasebillitem.getProduct().getTypesId().getName();
        this.vdate = purchasebillitem.getBill().getVdate();
        this.num = purchasebillitem.getNum();
        this.price = purchasebillitem.getPrice();
        this.amount = purchasebillitem.getAmount();
        this.status = purchasebillitem.getBill().getStatus();
        switch (groupBy){
            case "o.bill.supplier.name":
                this.groupField = supplier;
                break;
            case "o.bill.buyer.username":
                this.groupField = buyer;
                break;
            case "month(o.bill.vdate)":
                int month = DateUtils.toCalendar(vdate).get(Calendar.MONTH);
                this.groupField = (month+1) + "月";
                break;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getVdate() {
        return vdate;
    }

    public void setVdate(Date vdate) {
        this.vdate = vdate;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getGroupField() {
        return groupField;
    }

    public void setGroupField(String groupField) {
        this.groupField = groupField;
    }
}
