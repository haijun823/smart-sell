package com.zhonghaijun.ssj.service.impl;

import com.zhonghaijun.ssj.domain.Permission;
import com.zhonghaijun.ssj.query.BaseQuery;
import com.zhonghaijun.ssj.repository.BaseRepository;
import com.zhonghaijun.ssj.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public abstract class BaseServiceImpl<T,ID extends Serializable> implements BaseService<T,ID> {

    @Autowired
    private BaseRepository<T,ID> repository;


    @Override
    public List<T> findAllByQuery(BaseQuery query) {
        return repository.findAllByQuery(query);
    }

    @Override
    public Page<T> findPageByQuery(BaseQuery query) {
        return repository.findPageByQuery(query);
    }
    //获得所有
    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T findOne(ID id) {
        return repository.findOne(id);
    }

    @Override
    @Transactional
    public void merge(T t) {
        repository.save(t);
    }

    @Override
    @Transactional
    public void del(ID id) {
        repository.delete(id);
    }




}
