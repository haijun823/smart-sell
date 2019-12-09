package com.zhonghaijun.ssj.repository;

import com.zhonghaijun.ssj.domain.Menu;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends BaseRepository<Menu,Long> {

    @Query("select distinct m from Employee e join e.roles r join r.permissions p join p.menu m where e.id=?1")
    List<Menu> findMenusByEmployee(Long id);
}