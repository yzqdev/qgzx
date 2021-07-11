package com.qgzx.controller;

import com.qgzx.dto.Result;
import com.qgzx.entity.Admin;
import com.qgzx.entity.Job;
import com.qgzx.service.JobService;
import com.qgzx.mapper.JobMapper;
import com.qgzx.util.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author yanni
 */
@RestController
@Api(tags = "职位管理模块", value = "用户管理")

public class JobController {
    @Resource
    private JobService jobService;
    @Resource
    private JobMapper jobMapper;

    @RequestMapping(value = "/addJob", method = RequestMethod.POST)
    public Result addJob(@RequestBody Job job, HttpSession session) {
        Admin user = (Admin) session.getAttribute("admin");

        //if (user == null) {
        //    return new Result<>(false, "您还没有登陆", null);
        //}
        System.out.println(job.getHireNum());
        System.out.println("到达这里");

        boolean bool = false;

        try {

            bool = jobService.save(job);
            return ResultUtil.success("添加成功",job);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return ResultUtil.fail("未知错误");


    }


    @RequestMapping(value = "/getAllJobs", method = RequestMethod.GET)
    public Result getAllJobs() {


        try {
            List<Job> list = jobMapper.getAllJobs();

            return ResultUtil.success("获取成功", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.fail("失败了");
    }

    @RequestMapping(value = "/deleteJob/{id}", method = RequestMethod.DELETE)

    public Result deleteJob(@PathVariable("id") String id, HttpSession session) {


        Boolean bool = false;
        try {


            bool = jobService.removeById(id);

            if (!bool) {
                return ResultUtil.fail("删除失败");
            }
            return ResultUtil.success("删除成功",bool);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Result<>(true, "失败了", null);
    }

    @RequestMapping(value = "/updateJob", method = RequestMethod.PUT)

    public Result<String> updateJob(@RequestBody Job job, HttpSession session) {
        //User user = (User) session.getAttribute("user");
        //if (user == null) {
        //    return new Result<>(false, "您还没有登陆", null);
        //}
        boolean bool = false;

        try {
            bool = jobService.updateById(job);
        } catch (Exception e) {
            e.printStackTrace();

        }


        if (!bool) {
            ResultUtil.fail("失败了");
        }

        return new Result<>(true, "更新成功", null);
    }

    @RequestMapping(value = "/getJobById/{id}", method = RequestMethod.GET)

    public Result getJobById(@PathVariable("id") String id) {

        try {
            Job job = jobService.getJobById(id);
            return ResultUtil.success("成功了", job);
        } catch (Exception e) {
            e.printStackTrace();


        }
        return ResultUtil.fail("失败了");
    }

}
