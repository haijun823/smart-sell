package com.zhonghaijun.ssj.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "systemdictionarytype")
public class Systemdictionarytype extends BaseDomain {
    public static final String BRAND = "productBrand";
    public static final String UNIT = "productUnit";

    private String sn;
    private String name;


    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Systemdictionarytype{" +
                "sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}