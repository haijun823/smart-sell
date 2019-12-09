package com.zhonghaijun.ssj.service.impl;

import com.zhonghaijun.ssj.domain.Menu;
import com.zhonghaijun.ssj.repository.MenuRepository;
import com.zhonghaijun.ssj.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu,Long> implements MenuService {
    @Autowired
    private MenuRepository repository;

    @Override
    public List<Menu> findMenus(Long id) {
        //根据id获得所有的子菜单
        List<Menu> children = repository.findMenusByEmployee(id);
        //创建一个父菜单的集合
        ArrayList<Menu> parentList = new ArrayList<>();
        //遍历子菜单
        for (Menu menu : children) {
            //获取到父菜单
            Menu parent = menu.getParent();
            //判断存不存在
            if (!parentList.contains(parent)){
                //不存在，将父菜单存入父菜单集合中
                parentList.add(parent);
                //并且将子菜单添加到父菜单中
                parent.getChildren().add(menu);
            }else {
                //如果存在获得父菜单的索引
                int i = parentList.indexOf(parent);
                Menu m = parentList.get(i);
                //将子菜单添加进父菜单中
                m.getChildren().add(menu);
            }
        }
        return parentList;
    }
}