package com.wjx.osiris.lucian.proxys.cglib;

import com.wjx.osiris.lucian.proxys.Movie;
import com.wjx.osiris.lucian.proxys.VipMovie;

/**
 * @author wangjinxin
 * @date 2022/6/9 15:54
 * @mail wjxScott@163.com
 * @description
 */
public class Main {
    public static void main(String[] args) {
        Movie vipMovie = new VipMovie();

        CglibProxyInterceptor cglibProxyInterceptor = new CglibProxyInterceptor(vipMovie);

        Movie cglibInstance = (Movie) cglibProxyInterceptor.getInstance();

        cglibInstance.playMovie();
    }
}
