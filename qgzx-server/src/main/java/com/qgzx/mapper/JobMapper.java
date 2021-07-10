package com.qgzx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qgzx.entity.Job;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: Yangzhengqian
 * @Description:
 * @Date:Created time 2019/8/27 9:21
 * @Modified By:
 */
@Mapper
public interface JobMapper extends BaseMapper<Job> {


    @Select("select * from job")
    List<Job> getAllJobs();


    @Select("select count(*) from job")
    int getCount();

    @Select("select * from job where hireNum>0 and TO_DAYS(NOW()) - TO_DAYS(deadline) <= 0 order by id desc limit #{startPos},#{pageSize}")
    List<Job> getjobList(@Param("startPos") int startPos, @Param("pageSize") int pageSize);
}
