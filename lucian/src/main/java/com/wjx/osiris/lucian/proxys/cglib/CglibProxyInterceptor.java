package com.wjx.osiris.lucian.proxys.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author wangjinxin
 * @date 2022/6/9 16:00
 * @mail wjxScott@163.com
 * @description cglib 代理
 */
public class CglibProxyInterceptor implements MethodInterceptor {

    private Object object;

    public CglibProxyInterceptor(Object target) {
        this.object = target;
    }

    /**
     * 网上有些例子中这个方法的代码也可以写在test调用的地方
     *
     * @return
     */
    public Object getInstance() {
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(object.getClass());
        //设置回调
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib增强1");
        Object invoke = method.invoke(object, objects);
//        methodProxy.invokeSuper(o,objects);
        System.out.println("cglib增强2");
        return invoke;
    }
}
