package com.wjx.ezreal.builder;

import com.wjx.qilin.result.Result;

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
        Result success = Result.success(macBook);
        System.out.println(success);
        System.out.println(macBook);
        System.out.println(huaWeiBook);
    }
}
