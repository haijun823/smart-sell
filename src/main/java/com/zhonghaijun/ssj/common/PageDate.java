package com.zhonghaijun.ssj.common;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;

import java.util.List;

public class PageDate<T> {
    /**
     * 返回要求的Json数据格式
     */
    private Long total;        //总数据
    private List<T> rows;    //数据

    public PageDate(){}

    public PageDate(Page page) {
        this.rows = page.getContent();
        this.total = page.getTotalElements();
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
