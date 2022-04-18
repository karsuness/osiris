package com.wjx.osiris.galio.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liusha
 * @date 2022/4/17 16:53
 * @mail liusha@wacai.com
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("user")
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("user_name")
    private String userName;

    @TableField("password")
    private String password;

    @TableField("name")
    private String name;

    @TableField("age")
    private Integer age;

    @TableField(value = "email", select = false)//select 查询时不查询
    private String email;

    @TableField(exist = false)//数据表中不存在
    private String address;
}
