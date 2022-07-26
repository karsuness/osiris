package com.wjx.osiris.lucian.proxys.statics;

import com.wjx.osiris.lucian.proxys.Movie;

/**
 * @author wangjinxin
 * @date 2022/6/9 11:29
 * @mail wjxScott@163.com
 * @description 静态代理
 */
public class StaticMovieProxy implements Movie {

    private Movie movie;

    public StaticMovieProxy(Movie movie){
        this.movie = movie;
    }


    @Override
    public void playMovie() {
        System.out.println("增强---开始看电影前先看段广告........");
        movie.playMovie();
        System.out.println("增强---电影看完了再段广告........");
    }
}
