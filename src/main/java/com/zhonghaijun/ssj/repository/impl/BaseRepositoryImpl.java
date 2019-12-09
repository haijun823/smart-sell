package com.zhonghaijun.ssj.repository.impl;

import com.zhonghaijun.ssj.domain.Employee;
import com.zhonghaijun.ssj.query.BaseQuery;
import com.zhonghaijun.ssj.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class BaseRepositoryImpl<T,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements BaseRepository<T,ID> {

    private EntityManager em;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em = em;
    }

    //获得分页对象,并且排序
    @Override
    public Page<T> findPageByQuery(BaseQuery query) {
        return super.findAll(query.getSpec(),query.getPage());
    }
    //获得所有数据,并且不分页
    @Override
    public List<T> findAllByQuery(BaseQuery query) {
        return super.findAll(query.getSpec());
    }

    @Override
    public List getDataByJpql(String jpql, Object... values) {
        //给jpql赋值
        Query query = em.createQuery(jpql);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i+1, values[i]);
            }
        }
        return query.getResultList();
    }
}
