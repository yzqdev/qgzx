package com.qgzx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;
    private String password;
    @TableField("userName")
    private String userName;

    @TableField("phoneNumber")
    private String phoneNumber;

    private String qq;


}
