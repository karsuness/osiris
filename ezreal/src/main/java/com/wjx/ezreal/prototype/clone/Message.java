package com.wjx.ezreal.prototype.clone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangjinxin
 * @date 2021/3/16 11:57
 * @mail wjxScott@163.com
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message implements Cloneable {
    private String subject;

    private String content;

    @Override
    public Object clone() {
        Message message = null;
        try {
            message = (Message) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return message;
    }
}
