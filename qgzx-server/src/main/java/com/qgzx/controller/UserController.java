package com.qgzx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qgzx.dto.Result;
import com.qgzx.entity.User;
import com.qgzx.mapper.UserMapper;
import com.qgzx.service.UserService;
import com.qgzx.util.ResultUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author yanni
 */
@RestController
@Slf4j
@RequestMapping(value = "/user")

@Api(tags = "用户管理模块", value = "用户管理")
public class UserController {


    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;

    /**
     * 登录 login
     *
     * @return
     * @author zhangzhengan
     * @since JDK 1.7
     */

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<String> userLogin(@RequestBody User user ) {

        String result;
        System.out.println(user.toString());

        try {

            result = userService.userLogin(user);
        } catch (Exception e) {
            return new Result<>(false, "登录失败", null);
        }
        if (!"success".equals(result)) {
            return new Result<>(false, result, null);
        } else {
            log.info("登录成功：" + user);
            //session.setAttribute("user", user);
            return new Result<>(true, "登录成功", null);
        }
    }

    @GetMapping(value = "/getAllUsers")
    public Result<List<User>> getAllUsers() {
        List<User> allUsers = this.userService.getAllUsers();
        return new Result<>(true, "成功了", allUsers);
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public Result<String> userReg(@RequestBody User user) {

        String result;
        try {

            result = userService.userReg(user);
        } catch (Exception e) {
            return new Result<>(false, "注册失败", null);
        }
        if (!"success".equals(result)) {
            return new Result<>(false, result, null);
        } else {
            //log.info("登录成功：" + user);
            //session.setAttribute("user", user);
            return new Result<>(true, "注册成功", null);
        }
    }

    @GetMapping("/getQQ")
    public Result<?> getQQ() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("qq", "123");
        List<User> users = userService.list(queryWrapper);
        return ResultUtil.success("成功了", users);
    }

}
