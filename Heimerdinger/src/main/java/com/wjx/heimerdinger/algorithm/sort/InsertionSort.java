package com.wjx.heimerdinger.algorithm.sort;

import com.wjx.osiris.teemo.domain.enumeration.OrderEnum;

import java.util.Objects;

/**
 * @author wangjinxin
 * @date 2020/11/30 16:36
 * @mail wjxScott@iCloud.com
 * @description 插入排序
 */
public class InsertionSort {
    public static void insertionSort(int[] array, OrderEnum orderEnum) {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j;
            if (Objects.equals(OrderEnum.ORDER, orderEnum)) {
                for (j = i - 1; j >= 0 && temp < array[j]; j--) {
                    array[j + 1] = array[j];
                }
            } else {
                for (j = i - 1; j >= 0 && temp > array[j]; j--) {
                    array[j + 1] = array[j];
                }
            }
            array[j + 1] = temp;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("InsertionSort 耗时：" + (endTime - startTime));
    }
}
