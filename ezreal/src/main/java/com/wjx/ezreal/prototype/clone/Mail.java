package com.wjx.ezreal.prototype.clone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangjinxin
 * @date 2021/3/16 11:54
 * @mail wjxScott@163.com
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mail implements Cloneable {

    private String title;

    private String receiver;

    private Message message;

    @Override
    public Object clone() {
        Mail mail = new Mail();
        try {
            mail = (Mail) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        mail.message = (Message) message.clone();
        return mail;
    }
}
