package com.wjx.osiris.lucian.collect;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangjinxin
 * @date 2021/3/31 01:09
 * @mail wjxScott@iCloud.com
 * @description
 */
public class ListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(5);
        list.add("w");
        System.out.println(list.size());
        list.set(2,"q");
        System.out.println(list);
    }
}