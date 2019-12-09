package com.zhonghaijun.ssj.service;

import com.zhonghaijun.ssj.domain.Position;
import com.zhonghaijun.ssj.domain.Purchasebill;

import java.util.List;

public interface PurchasebillService extends BaseService<Purchasebill,Long> {  


    List<Purchasebill> findAllByPosition();

}