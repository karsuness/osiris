package com.wjx.osiris.lucian.jvm;

/**
 * @author liusha
 * @date 2022/2/15 21:04
 * @mail liusha@wacai.com
 * @description
 */
public class TestStatic {
    public static TestStatic t1 = new TestStatic();
    public static TestStatic t2 = new TestStatic();

    {
        System.out.println("构造块");
    }

    static {
        System.out.println("静态块");
    }

    public static void main(String[] args) {
        TestStatic t = new TestStatic();
    }
}
