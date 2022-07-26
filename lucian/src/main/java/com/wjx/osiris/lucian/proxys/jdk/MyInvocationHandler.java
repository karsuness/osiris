package com.wjx.osiris.lucian.proxys.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wangjinxin
 * @date 2022/6/9 12:03
 * @mail wjxScott@163.com
 * @description
 */
public class MyInvocationHandler implements InvocationHandler {

    /**
     * 真正的代理对象
     */
    private Object object;

    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("增强1");
        Object invoke = method.invoke(object, args);
        System.out.println("增强2");
        return invoke;
    }
}
