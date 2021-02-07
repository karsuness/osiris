package com.wjx.brand.main;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author WJX
 * @since 2018/5/6 16:51
 */
public class ArraysDemo {
    public static void main(String[] args) {
        int[] array = new int[10];

        //填充数组
        Arrays.fill(array, 5); //全部用5填充

        //第2到5个元素用9填充
        Arrays.fill(array, 1, 5, 9);

        int[] array1 = {7, 6, 5, 8, 12, 4, 31, 15};

        //转成stream
        Arrays.stream(array1).forEach(e -> System.out.print(e + " "));
        //排序
        Arrays.sort(array1);
        System.out.println();
        Arrays.stream(array1).forEach(e -> System.out.print(e + " "));

        //二分查找必须要求数组必须有序
        int i = Arrays.binarySearch(array1, 5);
        System.out.println(i);
    }
}
