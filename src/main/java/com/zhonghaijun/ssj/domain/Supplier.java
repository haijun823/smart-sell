package com.zhonghaijun.ssj.domain;

import javax.persistence.*;

@Entity
@Table(name = "supplier")
public class Supplier extends BaseDomain {

    private String name;

    public Supplier(){}

    public Supplier(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}