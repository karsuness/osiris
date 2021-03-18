package com.wjx.osiris.braum.algorithm.search;

/**
 * @author wangjinxin
 * @date 2020/12/11 15:35
 * @mail wjxScott@iCloud.com
 * @description 二分查找
 */
public class BinarySearch {
    public static int binarySearch(int[] array, int num) {
        if (array == null || array.length < 1) {
            return -1;
        }
        return innerBinarySearch(array, 0, array.length - 1, num);
    }

    private static int innerBinarySearch(int[] array, int start, int end, int num) {
        int mid = (start + end) / 2;
        if (start < end) {
            if (array[mid] > num) {
                return innerBinarySearch(array, start, mid, num);
            } else if (array[mid] < num) {
                return innerBinarySearch(array, mid + 1, end, num);
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
