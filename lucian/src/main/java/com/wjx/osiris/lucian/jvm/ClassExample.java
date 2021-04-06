package com.wjx.osiris.lucian.jvm;

/**
 * @author wangjinxin
 * @date 2021/4/6 21:41
 * @mail wjxScott@iCloud.com
 * @description
 */
public class ClassExample {

    public void set(User user) {
        user.setName("Hello");
        user = new User();
        user.setName("World");
    }

    public static void main(String[] args) {
        User user = new User();
        ClassExample classExample = new ClassExample();
        classExample.set(user);
        System.out.println(user.getName());
    }
}
