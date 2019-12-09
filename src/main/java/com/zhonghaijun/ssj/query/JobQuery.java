package com.zhonghaijun.ssj.query;

import com.github.wenhao.jpa.Specifications;
import com.zhonghaijun.ssj.domain.Job;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class JobQuery extends BaseQuery {


    private String title;

    private Integer positiontype;

    @Override
    //高级查询
    public Specification getSpec() {
        Specification<Job> specification = Specifications.<Job>and()
                .like(StringUtils.isNotBlank(title),"title","%"+title+"%")
                .eq(positiontype != null, "positiontype",positiontype)
                .build();
        return specification;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPositiontype() {
        return positiontype;
    }

    public void setPositiontype(Integer positiontype) {
        if (positiontype == -1){
            positiontype = null;
        }
        this.positiontype = positiontype;
    }
}