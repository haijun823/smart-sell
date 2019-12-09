package com.zhonghaijun.ssj.service.impl;

import com.zhonghaijun.ssj.domain.Job;
import com.zhonghaijun.ssj.repository.JobRepository;
import com.zhonghaijun.ssj.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl extends BaseServiceImpl<Job,Long> implements JobService {
    @Autowired
    private JobRepository repository;

}