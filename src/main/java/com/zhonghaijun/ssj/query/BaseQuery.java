package com.zhonghaijun.ssj.query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public abstract class BaseQuery {
    //获得当前页面
    private int currentPage=1;
    //获得需要查询的条数
    private int pageSize=10;
    //排序类型
    private String sortType = "ASC";
    //排序字段
    private String sortName;

    //创建Specification对象
    public abstract Specification getSpec();

    //获得分页对象
    public Pageable getPage(){
        //判断排序的字段有没有
        Sort sort = StringUtils.isNotBlank(sortName) ? new Sort(sortType.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC,sortName) : null;
        return new PageRequest(getCurrentPage(),getPageSize(),sort);
    }


    public int getCurrentPage() {
        //用户传值是从1开始传，但是查询是从0开始
        return currentPage - 1;
    }

    public void setPage(int page) {
        this.currentPage = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setRows(int rows) {
        this.pageSize = rows;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }
}
