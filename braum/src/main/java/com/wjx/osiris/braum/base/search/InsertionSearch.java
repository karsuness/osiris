package com.wjx.osiris.braum.base.search;

/**
 * @author wangjinxin
 * @date 2020/12/11 15:35
 * @mail wjxScott@iCloud.com
 * @description 插值查找
 */
public class InsertionSearch {
    public static int insertionSearch(int[] array, int num) {
        if (array == null || array.length < 1) {
            return -1;
        }
        return innerInsertionSearch(array, 0, array.length - 1, num);
    }

    private static int innerInsertionSearch(int[] array, int start, int end, int num) {
        int mid = start + (num - array[start]) / (array[end] - array[start]) * (end - start);
        if (start < end) {
            if (array[mid] > num) {
                return innerInsertionSearch(array, start, mid, num);
            } else if (array[mid] < num) {
                return innerInsertionSearch(array, mid + 1, end, num);
            } else {
                //array[mid] == num
                return mid;
            }
        } else {
            if (array[mid] == num) {
                return mid;
            } else {
                return -1;
            }
        }
    }
}
