package com.zhonghaijun.ssj.query;

import com.zhonghaijun.ssj.domain.Supplier;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.github.wenhao.jpa.Specifications;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class SupplierQuery extends BaseQuery {

                                
                

        private String name;

    @Override
    //高级查询
    public Specification getSpec() {
        Specification<Supplier> specification = Specifications.<Supplier>and()
        .like(StringUtils.isNotBlank(name),"name","%"+name+"%").build();          
        return specification;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}