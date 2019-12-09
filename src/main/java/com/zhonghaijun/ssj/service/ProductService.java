package com.zhonghaijun.ssj.service;

import com.zhonghaijun.ssj.domain.Product;

import java.util.List;

public interface ProductService extends BaseService<Product,Long> {

    List<Product> findProductsAll();
}