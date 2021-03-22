package com.wjx.osiris.braum.algorithm.sort;

import com.wjx.qilin.enumeration.OrderEnum;

import java.util.Objects;

/**
 * @author wangjinxin
 * @date 2020/11/30 21:32
 * @mail wjxScott@163.com
 * @description 希尔排序
 */
public class ShellSort {
    public static void shellSort(int[] array, OrderEnum orderEnum) {
        long startTime = System.currentTimeMillis();
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                if (Objects.equals(OrderEnum.ORDER, orderEnum)) {
                    while (j - gap >= 0 && array[j - gap] > array[j]) {
                        //swap
                        array[j - gap] = array[j - gap] + array[j];
                        array[j] = array[j - gap] - array[j];
                        array[j - gap] = array[j - gap] - array[j];

                        j -= gap;
                    }
                } else {
                    while (j - gap >= 0 && array[j - gap] < array[j]) {
                        //swap
                        array[j - gap] = array[j - gap] + array[j];
                        array[j] = array[j - gap] - array[j];
                        array[j - gap] = array[j - gap] - array[j];

                        j -= gap;
                    }
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("SelectionSort 耗时：" + (endTime - startTime));
    }
}

