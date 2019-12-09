package com.zhonghaijun.ssj.service.impl;

import com.zhonghaijun.ssj.domain.Supplier;
import com.zhonghaijun.ssj.repository.SupplierRepository;
import com.zhonghaijun.ssj.service.SupplierService;
import com.zhonghaijun.ssj.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl extends BaseServiceImpl<Supplier,Long> implements SupplierService {
    @Autowired
    private SupplierRepository repository;

}