package com.zhonghaijun.ssj.domain;

import javax.persistence.*;

@Entity
@Table(name = "producttype")
public class Producttype extends BaseDomain {


    private String name;
    private String descs;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "parent_id")
    private Producttype parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public Producttype getParentId() {
        return parentId;
    }

    public void setParentId(Producttype parentId) {
        this.parentId = parentId;
    }

    //前台实现二级联动
    public String getGroup(){
        if (parentId!=null){
            return parentId.getName();
        }
        return "";
    }

    @Override
    public String toString() {
        return "Producttype{" +
                "name='" + name + '\'' +
                ", descs='" + descs + '\'' +
                '}';
    }
}