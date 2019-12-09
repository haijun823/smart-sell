package com.zhonghaijun.ssj.query;

import com.zhonghaijun.ssj.domain.Systemdictionarydetail;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.github.wenhao.jpa.Specifications;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class SystemdictionarydetailQuery extends BaseQuery {

                                            
                                        
                

        private String name;
        private Long typesId;

    @Override
    //高级查询
    public Specification getSpec() {
        Specification<Systemdictionarydetail> specification = Specifications.<Systemdictionarydetail>and()
        .like(StringUtils.isNotBlank(name),"name","%"+name+"%").build();          
        return specification;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Long getTypesId() {
        return typesId;
    }

    public void setTypesId(Long typesId) {
        this.typesId = typesId;
    }
}