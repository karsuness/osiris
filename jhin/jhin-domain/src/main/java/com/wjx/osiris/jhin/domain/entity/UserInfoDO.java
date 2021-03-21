package com.wjx.osiris.jhin.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author wangjinxin
 * @date 2021/3/21 21:30
 * @mail wjxScott@icloud.com
 * @description 用户实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("user_info")
public class UserInfoDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 手机号
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 生日
     */
    @TableField("birth_date")
    private LocalDateTime birthDate;

    /**
     * 身份证号
     */
    @TableField("id_card_no")
    private String idCardNo;

    /**
     * 住址
     */
    @TableField("address")
    private String address;

    /**
     * 创建时间
     */
    @TableField("gmt_create")
    private LocalDateTime gmtCreate;

    /**
     * 最后修改时间
     */
    @TableField("gmt_modified")
    private LocalDateTime gmtModified;

    /**
     * 逻辑删除字段 0未删除，-1 已删除
     */
    @TableField("deleted")
    private Boolean deleted;


}
