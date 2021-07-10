package com.qgzx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Date;

/**
 * @author yanni
 */
@Data
@Accessors(chain = true)
@TableName(value = "Job")
public class Job {
	private static final long serialVersionUID = 1L;
	@TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;
    private String name;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;
    private String title;
    private String type;
    private String location;
    private String worktime;
    private String workplace;
    private String pay;
    @TableField("hireNum")
    private String hireNum;
    private Date deadline;
    private String sex;
    private String content;

	public Job() {
	}

}
