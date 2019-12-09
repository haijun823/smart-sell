package com.zhonghaijun.ssj.query;

import com.zhonghaijun.ssj.domain.Menu;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.github.wenhao.jpa.Specifications;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class MenuQuery extends BaseQuery {

                                            
                                        
                                        
                                        
                                        
                

        private String name;
        private String url;
        private String icon;
        private Long parentId;
        private String href;

    @Override
    //高级查询
    public Specification getSpec() {
        Specification<Menu> specification = Specifications.<Menu>and()
        .like(StringUtils.isNotBlank(name),"name","%"+name+"%").build();          
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
                
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
                
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
                
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
    }