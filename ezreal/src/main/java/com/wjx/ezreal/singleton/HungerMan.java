package com.wjx.ezreal.singleton;

/**
 * @author wangjinxin
 * @date 2021/3/9 23:04
 * @mail wjxScott@icloud.com
 * @description 饿汉单例模式
 */
public class HungerMan {
    public static final HungerMan INSTANCE = new HungerMan();

    /**
     * 私有化防止外界new对象
     */
    private HungerMan() {
    }

    public static HungerMan getInstance() {
        return INSTANCE;
    }
}
