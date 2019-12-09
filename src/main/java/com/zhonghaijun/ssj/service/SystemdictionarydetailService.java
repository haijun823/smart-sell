package com.zhonghaijun.ssj.service;

import com.zhonghaijun.ssj.domain.Systemdictionarydetail;

import java.util.List;

public interface SystemdictionarydetailService extends BaseService<Systemdictionarydetail,Long> {

    List<Systemdictionarydetail> findDetailsBySn(String sn);
}