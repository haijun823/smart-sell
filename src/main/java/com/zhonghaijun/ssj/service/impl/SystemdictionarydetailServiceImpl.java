package com.zhonghaijun.ssj.service.impl;

import com.zhonghaijun.ssj.domain.Systemdictionarydetail;
import com.zhonghaijun.ssj.repository.SystemdictionarydetailRepository;
import com.zhonghaijun.ssj.service.SystemdictionarydetailService;
import com.zhonghaijun.ssj.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemdictionarydetailServiceImpl extends BaseServiceImpl<Systemdictionarydetail,Long> implements SystemdictionarydetailService {
    @Autowired
    private SystemdictionarydetailRepository repository;

    @Override
    public List<Systemdictionarydetail> findDetailsBySn(String sn) {
        return repository.findDetailsBySn(sn);
    }
}