package com.qgzx.service.impl;

import com.qgzx.entity.Admin;
import com.qgzx.mapper.AdminMapper;
import com.qgzx.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yzq
 * @since 2020-04-16
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    @Override
    public String login(Admin admin) {

        if (admin == null) {
            return "登录的参数异常";
        }
        //登录的id
        String name = admin.getName();

        // 登录的密码
        String pass = admin.getPass();
        if (pass == null) {
            return "密码为空";
        }
        //手机号不为空

        if (!"".equals(name)) {
            try {
                Admin selectUser = adminMapper.getAdminByName(name);
                System.out.println(selectUser);
                if (selectUser == null) {
                    System.out.println("这里是");
                    return "该用户不存在";
                } else {
                    if (pass.equals(selectUser.getPass())) {
                        return "登录success"; // 登录成功
                    } else {
                        // 密码错误
                        return "密码错误";
                    }
                }
                // 用户不存在
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "成功";
    }


    @Override
    public List<Admin> getAllAdmins(String isSuper) {
        return adminMapper.getAllAdmins(isSuper);
    }
}
