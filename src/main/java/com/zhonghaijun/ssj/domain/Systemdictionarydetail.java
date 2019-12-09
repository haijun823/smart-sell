package com.zhonghaijun.ssj.domain;

import javax.persistence.*;

@Entity
@Table(name = "systemdictionarydetail")
public class Systemdictionarydetail extends BaseDomain {

    private String name;

    //optional设置不能为空
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "types_id")
    private Systemdictionarytype types;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Systemdictionarytype getTypes() {
        return types;
    }

    public void setTypes(Systemdictionarytype types) {
        this.types = types;
    }


    @Override
    public String toString() {
        return "Systemdictionarydetail{" +
                "name='" + name + '\'' +
                '}';
    }
}