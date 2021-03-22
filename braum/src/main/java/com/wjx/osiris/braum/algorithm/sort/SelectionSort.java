package com.wjx.osiris.braum.algorithm.sort;

import com.wjx.qilin.enumeration.OrderEnum;

import java.util.Objects;

/**
 * @author wangjinxin
 * @date 2020/11/30 15:08
 * @mail wjxScott@iCloud.com
 * @description 选择排序
 */
public class SelectionSort {
    public static void selectionSort(int[] array, OrderEnum orderEnum) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            int target = i;
            for (int j = i + 1; j < array.length; j++) {
                if (Objects.equals(OrderEnum.ORDER, orderEnum)) {
                    if (array[target] > array[j]) {
                        target = j;
                    }
                } else {
                    if (array[target] < array[j]) {
                        target = j;
                    }
                }
            }
            if (target != i) {
                //swap
                array[i] = array[i] + array[target];
                array[target] = array[i] - array[target];
                array[i] = array[i] - array[target];
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("SelectionSort 耗时：" + (endTime - startTime));
    }
}
