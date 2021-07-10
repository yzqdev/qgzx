package com.qgzx.controller;

import com.qgzx.dto.Result;
import com.qgzx.entity.Notice;
import com.qgzx.service.NoticeService;
import org.aspectj.weaver.ast.Not;
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
        return new Result<>("shibail", notice);
    }

    @GetMapping(value = "/getAllNotices")
    public Result getAllNotices(){
        List<Notice> noticeList=noticeService.list();

        return  new Result<>("ssdf",noticeList);
    }
    @DeleteMapping(value = "/deleteNotice/{id}")
    public Result deleteNotice(@PathVariable("id")  String id){
        Notice deletedNotice=noticeService.getById(id);
      boolean flag=  noticeService.removeById(id);
        return  new Result<>("aaa",flag);
    }
}
