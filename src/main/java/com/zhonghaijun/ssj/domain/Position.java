package com.zhonghaijun.ssj.domain;

import javax.persistence.*;

@Entity
@Table(name = "position")
public class Position extends BaseDomain {


    private String name;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "parent_id")
    //上级
    private Position parent;

    public Position getParent() {
        return parent;
    }

    public void setParent(Position parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}