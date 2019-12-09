package com.zhonghaijun.ssj.service.impl;

import com.zhonghaijun.ssj.common.UserContext;
import com.zhonghaijun.ssj.domain.Position;
import com.zhonghaijun.ssj.domain.Purchasebill;
import com.zhonghaijun.ssj.repository.PurchasebillRepository;
import com.zhonghaijun.ssj.service.PurchasebillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchasebillServiceImpl extends BaseServiceImpl<Purchasebill,Long> implements PurchasebillService {
    @Autowired
    private PurchasebillRepository repository;

    @Override
    public List<Purchasebill> findAllByPosition() {
        return repository.findAllByPosition(UserContext.getEmployee().getPosition());
    }
}