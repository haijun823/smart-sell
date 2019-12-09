package com.zhonghaijun.ssj.service.impl;

import com.zhonghaijun.ssj.domain.Product;
import com.zhonghaijun.ssj.repository.ProductRepository;
import com.zhonghaijun.ssj.service.ProductService;
import com.zhonghaijun.ssj.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product,Long> implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> findProductsAll() {
        return repository.findProductsAll();
    }
}