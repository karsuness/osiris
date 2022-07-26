package com.wjx.osiris.lucian.proxys;

/**
 * @author wangjinxin
 * @date 2022/6/9 11:29
 * @mail wjxScott@163.com
 * @description
 */
public class OriginalMovie implements Movie{
    @Override
    public void playMovie() {
        System.out.println("放映原始电影");
    }
}
