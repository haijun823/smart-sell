package com.zhonghaijun.ssj.repository;

import com.zhonghaijun.ssj.domain.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends BaseRepository<Product,Long> {
    @Query("select p from Product p join p.typesId t" +
            " join p.unitId uid  join p.brandId bid")
    List<Product> findProductsAll();
}