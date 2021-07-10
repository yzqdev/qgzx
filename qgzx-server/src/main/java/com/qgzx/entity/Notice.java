package com.qgzx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author yzq
 * @description
 * @date:Created time 2021/7/11 2:13
 * @modified By:
 */
@Data
public class Notice {

    @TableId(value="id",type= IdType.ASSIGN_ID)
    String id;
    String title;
    String subTitle;
    String content;
}
