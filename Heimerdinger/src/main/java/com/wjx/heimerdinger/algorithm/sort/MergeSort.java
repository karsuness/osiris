package com.wjx.heimerdinger.algorithm.sort;

/**
 * @author wangjinxin
 * @date 2020/11/30 22:40
 * @mail wjxScott@163.com
 * @description 归并排序
 */
public class MergeSort {
    public static void mergeSort(int[] array) {
        long startTime = System.currentTimeMillis();
        int[] temp = new int[array.length];
        sort(array, temp, 0, array.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("SelectionSort 耗时：" + (endTime - startTime));
    }

    private static void sort(int[] array, int[] temp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(array, temp, start, mid);
            sort(array, temp, mid + 1, end);
            merge(array, temp, start, mid, end);
        }
    }

    private static void merge(int[] array, int[] temp, int start, int mid, int end) {
        //左序列指针
        int i = start;
        //右序列指针
        int j = mid + 1;
        //临时数组指针
        int k = 0;
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        //剩余元素进入临时数组
        while (i <= mid) {
            temp[k++] = array[i++];
        }

        while (j <= end) {
            temp[k++] = array[j++];
        }

        k = 0;
        //将temp中元素放入原数组中
        while (start <= end) {
            array[start++] = temp[k++];
        }
    }
}
