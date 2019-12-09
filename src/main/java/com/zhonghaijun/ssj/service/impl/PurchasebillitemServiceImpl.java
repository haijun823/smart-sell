package com.zhonghaijun.ssj.service.impl;

import com.zhonghaijun.ssj.domain.PerchaseBillItemVo;
import com.zhonghaijun.ssj.domain.Purchasebillitem;
import com.zhonghaijun.ssj.query.PurchasebillitemQuery;
import com.zhonghaijun.ssj.repository.PurchasebillitemRepository;
import com.zhonghaijun.ssj.service.PurchasebillitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PurchasebillitemServiceImpl extends BaseServiceImpl<Purchasebillitem, Long> implements PurchasebillitemService {
    @Autowired
    private PurchasebillitemRepository repository;

    @Override
    public List<PerchaseBillItemVo> findItems(PurchasebillitemQuery query) {
        //根据传进来的条件，查找出所有的明细
        List<Purchasebillitem> items = repository.findAllByQuery(query);
        //创建一个装信息的集合
        ArrayList<PerchaseBillItemVo> list = new ArrayList<>();
        //遍历
        for (Purchasebillitem item : items) {
            //赋值
            PerchaseBillItemVo billItemVo = new PerchaseBillItemVo(item, query.getGroupBy());
            list.add(billItemVo);
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> findGroupByQuery(PurchasebillitemQuery query) {
        String jpql = "select " + query.getGroupBy() + ", sum(o.amount) from Purchasebillitem o " + query.getWhereJpql()
                + " group by " + query.getGroupBy();
        //分组查询
        List<Object[]> list = repository.getDataByJpql(jpql, query.getParams().toArray());
        System.out.println(list);
        //定义一个List集合把map装进来
        List<Map<String, Object>> maps = new ArrayList<>();
        for (Object[] objects : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", objects[0]);
            map.put("y", objects[1]);
            maps.add(map);
        }
        return maps;
    }


}