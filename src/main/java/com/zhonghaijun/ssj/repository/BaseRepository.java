package com.zhonghaijun.ssj.repository;


import com.zhonghaijun.ssj.query.BaseQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * 不要让接口实现
 */
@NoRepositoryBean
public interface BaseRepository<T,ID extends Serializable> extends JpaRepository<T,ID>,JpaSpecificationExecutor<T> {
    /**
     * 获得分页对象
     */
    Page<T> findPageByQuery(BaseQuery query);
    /**
     * 获得所有数据
     */
    List<T> findAllByQuery(BaseQuery query);
    /**
     * 根据JPQL获得对应数据
     */
    List getDataByJpql(String jpql,Object...value);


}
