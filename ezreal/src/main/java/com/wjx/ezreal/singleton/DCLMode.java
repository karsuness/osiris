package com.wjx.ezreal.singleton;

/**
 * @author liusha
 * @date 2021/3/9 23:23
 * @mail liusha@wacai.com
 * @description 双重锁检查
 */
public class DCLMode {

    private static volatile DCLMode INSTANCE;

    private DCLMode() {
    }

    public static DCLMode getInstance() {
        if (INSTANCE == null) {
            synchronized (DCLMode.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DCLMode();
                }
            }
        }
        return INSTANCE;
    }
}
