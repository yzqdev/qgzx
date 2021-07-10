package com.qgzx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qgzx.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @Author: Yangzhengqian
 * @Description:
 * @Date:Created time 2019/8/26 22:14
 * @Modified By:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
@Select("select * from user")
    List<User> getAllUsers();
}
