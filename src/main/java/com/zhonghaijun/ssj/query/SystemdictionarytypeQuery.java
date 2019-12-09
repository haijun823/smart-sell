package com.zhonghaijun.ssj.query;

import com.zhonghaijun.ssj.domain.Systemdictionarytype;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.github.wenhao.jpa.Specifications;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class SystemdictionarytypeQuery extends BaseQuery {

                                            
                                        
                

        private String sn;
        private String name;

    @Override
    //高级查询
    public Specification getSpec() {
        Specification<Systemdictionarytype> specification = Specifications.<Systemdictionarytype>and()
        .like(StringUtils.isNotBlank(name),"name","%"+name+"%").build();          
        return specification;
    }
    
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
}