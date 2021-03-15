package com.wjx.ezreal.singleton;

/**
 * @author wangjinxin
 * @date 2021/3/9 23:31
 * @mail wjxScott@icloud.com
 * @description 静态内部类单例模式
 */
public class InnerClassSingletonMode {

    private InnerClassSingletonMode() {
    }


    public static class SingletonModeHolder {
        private static final InnerClassSingletonMode INSTANCE = new InnerClassSingletonMode();
    }

    public static InnerClassSingletonMode getInstance() {
        return SingletonModeHolder.INSTANCE;
    }
}
