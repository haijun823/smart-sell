package com.zhonghaijun.ssj.service.impl;

import com.zhonghaijun.ssj.domain.Producttype;
import com.zhonghaijun.ssj.repository.ProducttypeRepository;
import com.zhonghaijun.ssj.service.ProducttypeService;
import com.zhonghaijun.ssj.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducttypeServiceImpl extends BaseServiceImpl<Producttype,Long> implements ProducttypeService {
    @Autowired
    private ProducttypeRepository repository;

    @Override
    public List<Producttype> findChildren() {
        return repository.findChildren();
    }

    @Override
    public List<Producttype> findParent() {
        return repository.findParent();
    }
}