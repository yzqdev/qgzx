package com.qgzx.controller;


import com.qgzx.dto.Result;
import com.qgzx.entity.Admin;
import com.qgzx.service.AdminService;
import com.qgzx.util.ResultEnum;
import com.qgzx.util.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 前端控制器
 *
 * @author yzq
 * @since 2020-04-16
 */
@RestController
@RequestMapping("/admin")

@Api(value = "管理登录", tags = "管理员")
public class AdminController {
    @Resource
    private AdminService adminService;


    @PostMapping("/login")
    public Result adminLogin(@RequestBody Admin admin, HttpSession session) {


        try {

            adminService.login(admin);
            session.setAttribute("admin", admin);
            return ResultUtil.success("登录成功了");
        } catch (Exception e) {
            return ResultUtil.fail( "登录失败", null);
        }

    }

    @PostMapping("/reg")
    public Result addAdmin(@RequestBody Admin admin) {
        try {

            boolean newadmin = adminService.save(admin);
            System.out.println(newadmin);
            return ResultUtil.success("添加成功",admin);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.fail("添加失败");
    }

    @GetMapping("/getAllAdmins")
    public Result getAllAdmins(@RequestParam("isSuper") String isSuper) {
        try {
            List<Admin> adminList = adminService.getAllAdmins(isSuper);
            System.out.println(adminList);

            return ResultUtil.success("获取成功", adminList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.fail("失败了");
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public Result deleteAdmin(@PathVariable("id") String id) {
        try {
            adminService.removeById(id);
            return ResultUtil.success("成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.fail("失败了");
    }

    @PutMapping("/updateAdmin")
    public Result updateAdmin(@RequestBody Admin admin) {
        try {
            adminService.updateById(admin);
            return ResultUtil.success("成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.fail("失败了");
    }
}
