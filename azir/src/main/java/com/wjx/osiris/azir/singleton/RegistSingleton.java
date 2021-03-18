package com.wjx.osiris.azir.singleton;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangjinxin
 * @date 2021/3/10 19:23
 * @mail wjxScott@icloud.com
 * @description 登记式单例模式
 */
public class RegistSingleton {

    /**
     * 使用线程安全的ConcurrentHashMap来维护映射关系
     */
    public static final Map<String, Object> REGIST = new ConcurrentHashMap<String, Object>();

    static {
        //将自己放入容器管理中
        RegistSingleton registSingleton = new RegistSingleton();
        REGIST.put(registSingleton.getClass().getName(), registSingleton);
    }

    private RegistSingleton() {
    }

    public static Object getInstance(String className) {
        //如果传入的类名为空，就返回RegistSingleton实例
        if (Objects.isNull(className)) {
            className = RegistSingleton.class.getName();
        }
        //如果容器中有就直接返回，没有就用反射创建一个，并将创建的对象返回
        if (!REGIST.containsKey(className)) {
            //没有登记就进入同步代码块,dcl
            synchronized (RegistSingleton.class) {
                if (!REGIST.containsKey(className)) {
                    try {
                        REGIST.put(className, Class.forName(className).newInstance());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        //返回实例
        return REGIST.get(className);
    }
}
