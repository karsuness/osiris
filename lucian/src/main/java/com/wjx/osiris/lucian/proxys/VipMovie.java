package com.wjx.osiris.lucian.proxys;

/**
 * @author wangjinxin
 * @date 2022/6/9 11:37
 * @mail wjxScott@163.com
 * @description
 */
public class VipMovie implements Movie{
    @Override
    public void playMovie() {
        System.out.println("开始放映VIP电影");
    }
}
