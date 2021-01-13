package com.wjx.heimerdinger.algorithm.sort;

import com.wjx.osiris.teemo.domain.enumeration.OrderEnum;

import java.util.Objects;

/**
 * @author wangjinxin
 * @date 2020/12/9 17:24
 * @mail wjxScott@163.com
 * @description 堆排序
 */
public class HeapSort {
    public static void heapSort(int[] array, OrderEnum orderEnum) {
        for (int i = 0; i < array.length - 1; i++) {
            //构造堆
            buildHeap(array, i, orderEnum);
            swap(array, 0, array.length - i - 1);
        }
    }

    private static void buildHeap(int[] array, int index, OrderEnum orderEnum) {
        for (int i = 0; i < array.length - index; i++) {
            checkHeap(array, i, orderEnum);
        }
    }

    private static void swap(int[] array, int first, int second) {
        array[first] = array[first] + array[second];
        array[second] = array[first] - array[second];
        array[first] = array[first] - array[second];
    }

    /**
     * 校验调整堆元素
     *
     * @param array
     * @param index
     * @param orderEnum
     */
    private static void checkHeap(int[] array, int index, OrderEnum orderEnum) {
        if (index == 0) {
            return;
        }
        //得到父节点
        int parent = index % 2 == 0 ? (index - 2) / 2 : (index - 1) / 2;
        if (Objects.equals(OrderEnum.ORDER, orderEnum)) {
            //升序排列构建大根堆
            if (array[parent] < array[index]) {
                //swap
                swap(array, index, parent);
                checkHeap(array, parent, orderEnum);
            }
        } else {
            //降序构建小跟堆
            if (array[parent] > array[index]) {
                swap(array, index, parent);
                checkHeap(array, parent, orderEnum);
            }
        }
    }
}
