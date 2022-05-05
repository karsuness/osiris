package com.wjx.osiris.hecarim.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author liusha
 * @date 2022/4/28 10:46
 * @mail liusha@wacai.com
 * @description
 */
@Getter
@AllArgsConstructor
public enum SexEnum implements IEnum<Integer> {

    MAN(1, "男"),
    WOMAN(2, "女");

    private Integer sex;
    private String message;

    @Override
    public Integer getValue() {
        return this.getSex();
    }
}
