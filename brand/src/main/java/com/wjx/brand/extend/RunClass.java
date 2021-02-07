package com.wjx.brand.extend;

/**
 * @author WJX
 * @since 2018/5/7 19:16
 */
public class RunClass {
    /*public static void main(String[] args) {
        ChildClass childClass = new ChildClass();
        int a = 1;
        int b = 2;
        childClass.sum(a,b);
    }*/

    public static void main(String[] args) {
        System.out.println("---------- new Child()");
        Child c = new Child();
        System.out.println("---------- c.action");
        c.action();
        Base b = c;
        System.out.println("---------- b.action");
        b.action();
    }
}
