package com.wjx.osiris.hecarim.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.wjx.osiris.hecarim.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author liusha
 * @date 2022/5/3 15:04
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
    private String username;

    @TableField("id_card_no")
    private String idCardNo;

    @TableField("birth_date")
    private LocalDate birthDate;

    private String mobile;

    @TableField("sex")
    private SexEnum sex;

    /**
     * 逻辑删除 0 未删除 1删除
     */
    @TableLogic
    private Integer deleted;
}
