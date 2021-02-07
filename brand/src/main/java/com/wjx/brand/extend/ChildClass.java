package com.wjx.brand.extend;

/**
 * @author WJX
 * @since 2018/5/7 19:14
 */
public class ChildClass extends BaseClass {
    public long sum(long a, long b) {
        System.out.println("child_long_long");
        return a + b;
    }
}
