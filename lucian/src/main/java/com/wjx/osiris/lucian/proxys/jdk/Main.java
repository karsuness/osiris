package com.wjx.osiris.lucian.proxys.jdk;


import com.wjx.osiris.lucian.proxys.Movie;
import com.wjx.osiris.lucian.proxys.VipMovie;

import java.lang.reflect.Proxy;

/**
 * @author wangjinxin
 * @date 2022/6/9 11:27
 * @mail wjxScott@163.com
 * @description 静态代理测试
 */
public class Main {
    public static void main(String[] args) {
        VipMovie vipMovie = new VipMovie();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(vipMovie);

        Movie jdkProxy = (Movie)Proxy.newProxyInstance(vipMovie.getClass().getClassLoader(), vipMovie.getClass().getInterfaces(), myInvocationHandler);

        jdkProxy.playMovie();
    }
}
