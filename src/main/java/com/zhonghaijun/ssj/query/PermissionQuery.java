package com.zhonghaijun.ssj.query;

import com.zhonghaijun.ssj.domain.Permission;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.github.wenhao.jpa.Specifications;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class PermissionQuery extends BaseQuery {


    private String name;
    private String url;
    private String descs;
    private String sn;
    private Long menuId;

    @Override
    //高级查询
    public Specification getSpec() {
        System.out.println(name);
        Specification<Permission> specification = Specifications.<Permission>and()
                .like(StringUtils.isNotBlank(name),"name", "%"+name+"%")
                .like(StringUtils.isNotBlank(url),"url","%"+url+"%" )
                .like(StringUtils.isNotBlank(descs),"descs","%"+descs+"%")
                .like(StringUtils.isNotBlank(sn),"sn","%"+sn+"%")
                .build();
        return specification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}