package com.zhonghaijun.ssj.repository;

import com.zhonghaijun.ssj.domain.Department;

public interface DepartmenRepository extends BaseRepository<Department,Long> {

    //通过名字来获取部门
    Department findByName(String name);

}
