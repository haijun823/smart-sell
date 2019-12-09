package com.zhonghaijun.ssj.shiro;

import com.zhonghaijun.ssj.domain.Permission;
import com.zhonghaijun.ssj.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FilterChainDefinitions {
    @Autowired
    private PermissionService service;

    public Map<String,String > createMap(){
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("/login/**", "anon");
        map.put("/job/**", "anon");
        map.put("/html/**", "anon");
        map.put("/js/**", "anon");
        map.put("/easyui/**", "anon");
        map.put("/common/**", "anon");
        map.put("/css/**", "anon");
        map.put("/images/**", "anon");
        map.put("/logout", "logout");
        List<Permission> list = service.findAll();
        for (Permission permission : list) {
            map.put(permission.getUrl(), "yxbFilter["+permission.getSn()+"]");
        }
        map.put("/**", "authc");
        return map;
    }

}
