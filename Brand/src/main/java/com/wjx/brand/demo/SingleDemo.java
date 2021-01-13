package com.wjx.brand.demo;

/**
 * @author WJX
 * @since 2018/5/21 10:54
 */

import java.util.Objects;

/**
 * 考虑线程安全的情况下完成一个单例模式
 */
public class SingleDemo {
    private SingleDemo() {
    }

    private static class SingletonHolder {
        private static final SingleDemo INSTANCE = new SingleDemo();
    }

    public static SingleDemo getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * main测试
     */
    public static void main(String[] args) {
        SingleDemo instance1 = getInstance();
        SingleDemo instance2 = getInstance();
        //返回结果为true则正确
        System.out.println(Objects.equals(instance1, instance2));
    }
}
