package com.wjx.osiris.braum.base.search;

import java.util.Arrays;

/**
 * @author wangjinxin
 * @date 2020/12/14 21:30
 * @mail wjxScott@163.com
 * @description 斐波那契查找
 */
public class FibonacciSearch {

    public static int fibonacciSearch(int[] array, int num) {
        if (array == null || array.length < 1) {
            return -1;
        }


        int length = array.length;
        //先生成10位长度的斐波那契数组
        int[] fibonacci = createFibonacci(10);

        int k = 0;
        //找到数组长度最接近的斐波那契数的坐标
        while (length > fibonacci[k] - 1) {
            k++;
        }

        //构建数组
        int[] temp = Arrays.copyOf(array, fibonacci[k] - 1);

        //末尾使用最大数进行填充
        for (int i = length; i < temp.length; i++) {
            if (i >= length) {
                temp[i] = array[length - 1];
            }
        }

        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + fibonacci[k - 1] - 1;
            if (temp[mid] > num) {
                high = mid - 1;
                k--;
            } else if (temp[mid] < num) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    //mid的值已经大于high说明进入填充数组，最后一个数就是需要查找的书
                    return high;
                }
            }
        }
        return -1;
    }


    private static int[] createFibonacci(int num) {
        int[] array = new int[num];

        if (num < 2) {
            throw new RuntimeException("斐波那契数组长度不能小于2");
        }

        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < num; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array;
    }
}
