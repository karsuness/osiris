package com.wjx.brand.extend;

/**
 * @author WJX
 * @since 2018/5/7 20:46
 */
public class Child extends Base {
    public static int s;

    private int a;

    static {
        System.out.println("子类静态代码块，s:" + s);
        s = 10;
    }

    {
        System.out.println("基本实例代码块，a:" + a);
        a = 10;
    }

    public Child() {
        System.out.println("子类构造方法，a:" + a);
        a = 20;
    }

    @Override
    protected void step() {
        System.out.println("child s:" + s + ",a:" + a);
    }
}
