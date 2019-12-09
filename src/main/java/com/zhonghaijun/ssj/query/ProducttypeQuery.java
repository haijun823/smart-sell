package com.zhonghaijun.ssj.query;

import com.zhonghaijun.ssj.domain.Producttype;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.github.wenhao.jpa.Specifications;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class ProducttypeQuery extends BaseQuery {

    private String name;
    private String descs;
    private Long parentId;

    @Override
    //高级查询
    public Specification getSpec() {
        Specification<Producttype> specification = Specifications.<Producttype>and()
                .like(StringUtils.isNotBlank(name), "name", "%" + name + "%").build();
        return specification;
    }

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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}