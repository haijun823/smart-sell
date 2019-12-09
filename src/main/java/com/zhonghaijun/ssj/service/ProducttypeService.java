package com.zhonghaijun.ssj.service;

import com.zhonghaijun.ssj.domain.Producttype;

import java.util.List;

public interface ProducttypeService extends BaseService<Producttype,Long> {

    List<Producttype> findChildren();

    List<Producttype> findParent();
}