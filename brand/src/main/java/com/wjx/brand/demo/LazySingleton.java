package com.wjx.brand.demo;

/**
 * @author WJX
 * @since 2018/5/21 13:14
 */

/**
 * 单例模式中懒汉模式
 * <p>
 * 懒汉模式的特点是：延迟加载，配置文件等到使用的时候才会加载
 * 在类加载的时候不创建单例实例。只有在第一次请求实例的时候的时候创建，并且只在第一次创建后，以后不再创建该类的实例
 */
public class LazySingleton {

    private static LazySingleton lazySingleton = null;

    private LazySingleton() {
    }

    synchronized public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
