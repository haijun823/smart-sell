package com.zhonghaijun.ssj.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.wenhao.jpa.Specifications;
import com.zhonghaijun.ssj.domain.Product;
import com.zhonghaijun.ssj.domain.Purchasebillitem;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchasebillitemQuery extends BaseQuery {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private Integer status;

    private String groupBy = "o.bill.supplier.name";

    //定义一个集合，该集合是专门用来装？对应的值
    private List<Object> params = new ArrayList<>();

    @Override
    //高级查询
    public Specification getSpec() {
        //当查询同一天时的时间
        Date tempDate = null;
        if(endDate!=null){
            tempDate = DateUtils.addDays(endDate,1);
        }
        Specification<Purchasebillitem> specification = Specifications.<Purchasebillitem>and()
                .eq(status!=null,"bill.status",status )//等于
                .ge(beginDate!=null, "bill.vdate",beginDate) //大于等于
                .lt(endDate!=null, "bill.vdate",tempDate) //小于等于
                .build();
        return specification;
    }

    public List<Object> getParams() {
        return params;
    }

    public String getWhereJpql(){
        //定义一个StringBuilder，该builder是专门来拼接whereJpql语句的
        StringBuilder whereBuilder = new StringBuilder();
        if (status != null) {
            whereBuilder.append(" and o.bill.status=? ");
            params.add(status);
        }
        if (beginDate != null) {
            whereBuilder.append(" and o.bill.vdate>=? ");
            params.add(beginDate);
        }
        if(endDate != null){
            whereBuilder.append(" and o.bill.vdate<? ");
            params.add(DateUtils.addDays(endDate,1));
        }
        return whereBuilder.toString().replaceFirst("and", "where");
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    public void setParams(List<Object> params) {
        this.params = params;
    }
}