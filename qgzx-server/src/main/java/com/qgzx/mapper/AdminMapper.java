package com.qgzx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qgzx.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: Yangzhengqian
 * @Description:
 * @Date:Created time 2020/4/16 13:11
 * @Modified By:
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    List<Admin> getAllAdmins(String isSuper);

    Admin getAdminByName(String name);

}
