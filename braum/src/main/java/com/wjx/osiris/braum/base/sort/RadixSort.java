package com.wjx.osiris.braum.base.sort;

import java.util.ArrayList;

/**
 * @author wangjinxin
 * @date 2020/12/11 14:36
 * @mail wjxScott@iCloud.com
 * @description 基数排序
 */
public class RadixSort {
    public static void radixSort(int[] array) {
        int digit = getMaxDigit(array);
        for (int i = 0; i < digit; i++) {
            bucketSort(array, i);
        }
    }

    private static void bucketSort(int[] array, int digit) {
        int base = (int) Math.pow(10, digit);
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        //只有0-9这10个数，所以准备十个桶
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int num : array) {
            int index = num / base % 10;
            buckets.get(index).add(num);
        }

        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int num : bucket) {
                array[index++] = num;
            }
        }
    }

    /**
     * 获取数组中最大元素的位数
     *
     * @param array
     * @return
     */
    private static int getMaxDigit(int[] array) {
        //默认一位
        int digit = 1;
        int base = 10;
        for (int num : array) {
            while (num > base) {
                digit++;
                base *= 10;
            }
        }
        return digit;
    }
}
