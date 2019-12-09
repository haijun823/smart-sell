package com.zhonghaijun.ssj.service;

import com.zhonghaijun.ssj.domain.Menu;

import java.util.List;

public interface MenuService extends BaseService<Menu,Long> {  

    List<Menu> findMenus(Long id);

}