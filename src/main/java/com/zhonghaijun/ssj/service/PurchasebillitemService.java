package com.zhonghaijun.ssj.service;

import com.zhonghaijun.ssj.domain.PerchaseBillItemVo;
import com.zhonghaijun.ssj.domain.Purchasebillitem;
import com.zhonghaijun.ssj.query.PurchasebillitemQuery;

import java.util.List;
import java.util.Map;

public interface PurchasebillitemService extends BaseService<Purchasebillitem,Long> {


    //通过条件来查找所有明细
    List<PerchaseBillItemVo> findItems(PurchasebillitemQuery query);

    List<Map<String,Object>> findGroupByQuery(PurchasebillitemQuery query);
}