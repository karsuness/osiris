package com.wjx.osiris.lucian.jvm;

/**
 * @author wangjinxin
 * @date 2021/4/7 23:29
 * @mail wjxScott@iCloud.com
 * @description
 */
public class FinallyExample {
    public static int method() {
        int a = 10;
        try {
            a = a / 0;
            System.out.println("this is try code");
        } catch (Exception e) {
            a = 20;
            System.out.println("this is catch code");
            return a; //☆
        } finally {
            a = 30;
            System.out.println("this is finally code");
        }
        return a;
    }

    public static void main(String[] args) {
        int method = method();
        System.out.println(method);
    }
}
