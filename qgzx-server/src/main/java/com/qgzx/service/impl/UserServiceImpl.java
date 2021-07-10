package com.qgzx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qgzx.entity.User;
import com.qgzx.service.UserService;
import com.qgzx.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yanni
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public String userLogin(User user) throws Exception {
        if (user == null) {
            return "登录的参数异常";
        }

        //登录的id
        String id = user.getId();

        // 登录的密码
        String password = user.getPassword();

        if (password == null) {
            return "密码为空";
        }
        //手机号不为空

        if (id.length()>0 ) {
            User selectUser = userMapper.selectById(id);
            // 用户不存在
            System.out.println(selectUser.toString());
            if (selectUser == null) {
                return "该用户不存在";
            } else {
                if (password.equals(selectUser.getPassword())) {
                    // 登录成功
                } else {
                    // 密码错误
                    return "密码错误";
                }
            }
        } else {
            return "账号为空";
        }
        return "success";
    }

    @Override
    public String userReg(User user) {
        //判断用户名是否已存在
        try {
            User accountGet;
            accountGet=userMapper.selectById(user.getId());
            if (accountGet!=null){
                return "账户已存在";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if (userMapper.insert(user) == 0) {
           return "添加失败";
        }
        return "success";
    }

    @Override
    public List<User> getAllUsers() {
        try {
            List<User> allUsers= this.userMapper.getAllUsers();
            return allUsers;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
