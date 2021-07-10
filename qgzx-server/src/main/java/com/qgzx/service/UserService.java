package com.qgzx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qgzx.entity.User;

import java.util.List;


public interface UserService extends IService<User> {

	String userLogin(User user) throws Exception;
	String userReg(User user);

    List<User> getAllUsers();
}
