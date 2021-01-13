package com.wjx.brand.demo;

/**
 * @author WJX
 * @since 2018/5/21 13:20
 */

/**
 * 单例模式中饿汉模式：
 */
public class EagerSingleton {
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}
