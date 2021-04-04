package com.wjx.osiris.braum.base.search;

/**
 * @author wangjinxin
 * @date 2020/12/11 15:23
 * @mail wjxScott@iCloud.com
 * @description 顺序查找
 */
public class OrderSearch {
    public static int orderSearch(int[] array, int num) {
        if (array == null || array.length < 1) {
            return -1;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                return i;
            }
        }
        return -1;
    }
}
