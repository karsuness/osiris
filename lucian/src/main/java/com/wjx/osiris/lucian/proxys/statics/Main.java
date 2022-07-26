package com.wjx.osiris.lucian.proxys.statics;

import com.wjx.osiris.lucian.proxys.OriginalMovie;

/**
 * @author wangjinxin
 * @date 2022/6/9 11:27
 * @mail wjxScott@163.com
 * @description 静态代理测试
 */
public class Main {
    public static void main(String[] args) {

        OriginalMovie originalMovie = new OriginalMovie();

        StaticMovieProxy staticMovieProxy = new StaticMovieProxy(originalMovie);

        staticMovieProxy.playMovie();
    }
}