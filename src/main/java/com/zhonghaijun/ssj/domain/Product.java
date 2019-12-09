package com.zhonghaijun.ssj.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product extends BaseDomain {


    private String name;
    private String color;
    private String pic;
    private String smallpic;
    private BigDecimal costprice;
    private BigDecimal saleprice;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "types_id")
    private Producttype typesId;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "unit_id")
    private Systemdictionarydetail unitId;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "brand_id")
    private Systemdictionarydetail brandId;


    public Product(){}

    public Product(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getSmallpic() {
        return smallpic;
    }

    public void setSmallpic(String smallpic) {
        this.smallpic = smallpic;
    }

    public BigDecimal getCostprice() {
        return costprice;
    }

    public void setCostprice(BigDecimal costprice) {
        this.costprice = costprice;
    }

    public BigDecimal getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(BigDecimal saleprice) {
        this.saleprice = saleprice;
    }

    public Producttype getTypesId() {
        return typesId;
    }

    public void setTypesId(Producttype typesId) {
        this.typesId = typesId;
    }

    public Systemdictionarydetail getUnitId() {
        return unitId;
    }

    public void setUnitId(Systemdictionarydetail unitId) {
        this.unitId = unitId;
    }

    public Systemdictionarydetail getBrandId() {
        return brandId;
    }

    public void setBrandId(Systemdictionarydetail brandId) {
        this.brandId = brandId;
    }


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", pic='" + pic + '\'' +
                ", smallpic='" + smallpic + '\'' +
                ", costprice=" + costprice +
                ", saleprice=" + saleprice +
                '}';
    }
}