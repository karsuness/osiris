package com.wjx.osiris.braum.base.sort;

/**
 * @author wangjinxin
 * @date 2020/12/3 11:07
 * @mail wjxScott@iCloud.com
 * @description 快速排序
 */
public class QuickSort {
    public static void quickSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int start, int end) {
        if (start > end) {
            return;
        } else {
            int divide = divide(array, start, end);
            sort(array, start, divide - 1);
            sort(array, divide + 1, end);
        }

    }

    /**
     * 对每个分区进行排序并返回中间基准值的下标
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private static int divide(int[] array, int start, int end) {
        //选择数组最后一个元素作为基准（也可以选择数组第一个元素）
        int datum = array[end];

        while (start < end) {
            //先从距离基准元素最远的下标开始搜索
            while ((start < end) && (array[start] <= datum)) {
                start++;
            }
            if (start < end) {
                //swap
                array[end] = array[start] + array[end];
                array[start] = array[end] - array[start];
                array[end] = array[end] - array[start];
                end--;
            }
            //开始走另一边
            while ((start < end) && (array[end] >= datum)) {
                end--;
            }
            if (start < end) {
                //swap
                array[end] = array[start] + array[end];
                array[start] = array[end] - array[start];
                array[end] = array[end] - array[start];
                start++;
            }
        }
        return end;
    }
}
