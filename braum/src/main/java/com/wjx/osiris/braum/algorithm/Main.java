package com.wjx.osiris.braum.algorithm;



import com.wjx.osiris.braum.algorithm.search.InsertionSearch;
import com.wjx.osiris.braum.algorithm.sort.QuickSort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wangjinxin
 * @date 2020/11/30 11:53
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
        System.out.println("排序前的数组是：" + Arrays.toString(array));
//        BubbleSort.bubbleSort(array, OrderEnum.REVERSE_ORDER);
//        SelectionSort.selectionSort(array, OrderEnum.ORDER);
//        InsertionSort.insertionSort(array, OrderEnum.REVERSE_ORDER);
//        ShellSort.shellSort(array, OrderEnum.ORDER);
//        MergeSort.mergeSort(array);
        QuickSort.quickSort(array);
//        int[] ints = CountSort.countSort(array);
//        int[] ints = BucketSort.bucketSort(array);
//        System.out.println("排序后的数组是：" + Arrays.toString(ints));
//        RadixSort.radixSort(array);
        System.out.println("排序后的数组是：" + Arrays.toString(array));
        int num = array[random.nextInt(10)];
        int index = InsertionSearch.insertionSearch(array, num);
        System.out.println("需要查找的数是：" + num + ",查到的下标是：" + index);
    }
}
