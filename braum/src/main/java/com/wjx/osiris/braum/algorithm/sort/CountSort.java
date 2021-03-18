package com.wjx.osiris.braum.algorithm.sort;

/**
 * @author wangjinxin
 * @date 2020/12/10 15:14
 * @mail wjxScott@iCloud.com
 * @description 计数排序
 */
public class CountSort {
    public static int[] countSort(int[] array) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //找到最大值和最小值
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }

        //创建临时数组
        int[] tempArray = new int[max - min + 1];

        for (int i = 0; i < array.length; i++) {
            int position = array[i] - min;
            tempArray[position]++;
        }

        //计算下标
        for (int i = 1; i < tempArray.length; i++) {
            tempArray[i] = tempArray[i - 1] + tempArray[i];
        }

        //排序
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int position = --tempArray[array[i] - min];
            result[position] = array[i];
        }
        return result;
    }
}
