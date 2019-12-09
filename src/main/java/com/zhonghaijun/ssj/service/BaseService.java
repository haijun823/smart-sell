package com.zhonghaijun.ssj.service;


import com.zhonghaijun.ssj.query.BaseQuery;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 不要让接口实现
 */
public interface BaseService<T,ID> {

    //获得所有根据高级查询信息
    List<T> findAllByQuery(BaseQuery query);
    //分页
    Page<T> findPageByQuery(BaseQuery query);
    //查找所有
    List<T> findAll();
    //获得一个
    T findOne(ID id);
    //修改、添加
    void merge(T t);
    //删除
    void del(ID id);


}
