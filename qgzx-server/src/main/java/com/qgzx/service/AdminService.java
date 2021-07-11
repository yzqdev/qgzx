package com.qgzx.service;

import com.qgzx.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author yzq
 * @since 2020-04-16
 */
public interface AdminService extends IService<Admin> {

    String login(Admin admin);

    List<Admin> getAllAdmins(String isSuper);
}
