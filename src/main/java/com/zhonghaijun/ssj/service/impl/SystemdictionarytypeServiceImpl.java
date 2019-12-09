package com.zhonghaijun.ssj.service.impl;

import com.zhonghaijun.ssj.domain.Systemdictionarytype;
import com.zhonghaijun.ssj.repository.SystemdictionarytypeRepository;
import com.zhonghaijun.ssj.service.SystemdictionarytypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemdictionarytypeServiceImpl extends BaseServiceImpl<Systemdictionarytype,Long> implements SystemdictionarytypeService {
    @Autowired
    private SystemdictionarytypeRepository repository;

}