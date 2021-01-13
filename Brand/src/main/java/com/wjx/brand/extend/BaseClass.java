package com.wjx.brand.extend;

/**
 * @author WJX
 * @since 2018/5/7 19:09
 */
public class BaseClass {
    public int sum(int a, int b) {
        System.out.println("base_int_int");
        return a + b;
    }

    public long sum(int a, long b) {
        System.out.println("base_int_long");
        return a + b;
    }
}
