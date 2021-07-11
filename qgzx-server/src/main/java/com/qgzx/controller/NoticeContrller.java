package com.qgzx.controller;

import com.qgzx.dto.Result;
import com.qgzx.entity.Notice;
import com.qgzx.service.NoticeService;
import com.qgzx.util.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yzq
 * @description
 * @date:Created time 2021/7/11 2:17
 * @modified By:
 */
@RestController
public class NoticeContrller {
    @Resource
    NoticeService noticeService;

    @PostMapping(value = "/addNotice")
    public Result addNotice(@RequestBody Notice notice) {

        noticeService.save(notice);
        return ResultUtil.success("添加成功",notice);
    }

    @GetMapping(value = "/getAllNotices")
    public Result getAllNotices(){
        List<Notice> noticeList=noticeService.list();

        return  ResultUtil.success(noticeList);
    }
    @DeleteMapping(value = "/deleteNotice/{id}")
    public Result deleteNotice(@PathVariable("id")  String id){
        Notice deletedNotice=noticeService.getById(id);
      boolean flag=  noticeService.removeById(id);
        return  ResultUtil.success("删除成功",flag);
    }
    @PutMapping(value = "/updateNotice")
    public Result updateNotice(@RequestBody Notice notice){
       boolean flag= noticeService.updateById(notice);
       Notice newNotice=noticeService.getById(notice.getId());
        return  ResultUtil.success("修改成功",newNotice);
    }
}
