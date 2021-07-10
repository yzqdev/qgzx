package com.qgzx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qgzx.entity.Job;


public interface JobService extends IService<Job> {




    public Job getJobById(String id);

    public int getCount();

}
