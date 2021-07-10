package com.qgzx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author yzq
 * @since 2020-04-16
 */
@Data
@Accessors(chain = true)
@TableName(value = "admin")
public class Admin {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    private String name;

    private String pass;
    @TableField("isSuper")
    private String isSuper;
}
