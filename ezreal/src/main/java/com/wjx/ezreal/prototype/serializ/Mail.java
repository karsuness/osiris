package com.wjx.ezreal.prototype.serializ;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;

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
public class Mail implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;

    private String receiver;

    private Message message;

    public Mail cloneMail() {
        Mail mail = null;
        try {
            // 将该对象序列化成流,因为写在流里的是对象的一个拷贝，而原对象仍然存在于JVM里面。所以利用这个特性可以实现对象的深拷贝
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            mail = (Mail) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return mail;
    }
}
