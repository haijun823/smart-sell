package com.zhonghaijun.ssj.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.wenhao.jpa.Specifications;
import com.zhonghaijun.ssj.domain.Purchasebill;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class PurchasebillQuery extends BaseQuery {

   private Date beginTime;
   private Date endTime;
   private Integer status;

    @Override
    //高级查询
    public Specification getSpec() {
        //给最后一天的加一天，不然同一天的查不出来
        if(endTime != null){
            endTime = DateUtils.addDays(endTime, 1);
        }
        Specification<Purchasebill> specification = Specifications.<Purchasebill>and()
                .eq(status != null,"status",status)
                .ge(beginTime!=null,"vdate",beginTime )
                .lt(endTime !=null, "vdate",endTime)
                .build();
        return specification;
    }
    public Date getBeginTime() {
        return beginTime;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}