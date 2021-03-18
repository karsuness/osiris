package com.wjx.osiris.azir.builder;

/**
 * @author wangjinxin
 * @date 2021/3/15 22:59
 * @mail wjxScott@icloud.com
 * @description
 */
public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        Computer macBook = director.getMacBook();
        Computer huaWeiBook = director.getHuaWeiBook();
        System.out.println(macBook);
        System.out.println(huaWeiBook);
    }
}
