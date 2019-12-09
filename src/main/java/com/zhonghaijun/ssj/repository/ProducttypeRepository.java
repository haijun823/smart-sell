package com.zhonghaijun.ssj.repository;

import com.zhonghaijun.ssj.domain.Producttype;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProducttypeRepository extends BaseRepository<Producttype,Long> {

    //查询子下拉框
    @Query("select p from Producttype p where p.parentId.id is not null ")
    List<Producttype> findChildren();
    @Query("select p from Producttype  p where p.parentId.id is null")
    List<Producttype> findParent();
}