package com.qgzx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qgzx.entity.Job;
import com.qgzx.service.JobService;
import com.qgzx.mapper.JobMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JobImpl extends ServiceImpl<JobMapper, Job> implements JobService {

    @Resource
    private JobMapper jobMapper;
    @Resource
    private JobService jobService;




    public Boolean updateJob(Job job) throws Exception {
        int hasUpdate = 1;
        System.out.println(job);
        try {
            String id = job.getId();

            jobService.updateById(job);
            return hasUpdate == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hasUpdate == 1;
    }




    @Override
    public Job getJobById(String id) {
        return jobMapper.selectById(id);
    }

    @Override
    public int getCount() {
        return jobMapper.getCount();
    }




}
