package com.zhonghaijun.ssj.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
//@JsonIgnoreProperties(value={"hibernateLazyInitializer","validate","fieldHandler"})
public class BaseDomain implements Serializable {

    @Id
    @GeneratedValue
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseDomain{" +
                "id=" + id +
                '}';
    }
}
