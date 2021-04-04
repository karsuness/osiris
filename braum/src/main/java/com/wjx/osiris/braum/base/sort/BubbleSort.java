package com.wjx.osiris.braum.base.sort;

import com.wjx.qilin.enumeration.OrderEnum;

import java.util.Objects;

/**
 * @author wangjinxin
 * @date 2020/11/30 11:46
 * @mail wjxScott@iCloud.com
 * @description 冒泡排序
 */
public class BubbleSort {
    public static void bubbleSort(int[] array, OrderEnum orderEnum) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (Objects.equals(OrderEnum.ORDER, orderEnum)) {
                    //顺序排列
                    if (array[j] > array[j + 1]) {
                        //交换
                        array[j] = array[j] + array[j + 1];
                        array[j + 1] = array[j] - array[j + 1];
                        array[j] = array[j] - array[j + 1];
                    }
                } else {
                    if (array[j] < array[j + 1]) {
                        //交换
                        array[j] = array[j] + array[j + 1];
                        array[j + 1] = array[j] - array[j + 1];
                        array[j] = array[j] - array[j + 1];
                    }
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("BubbleSort 耗时：" + (endTime - startTime));
    }
}
