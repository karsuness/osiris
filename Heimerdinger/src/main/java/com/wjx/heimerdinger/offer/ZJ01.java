package com.wjx.heimerdinger.offer;

/**
 * @author wangjinxin
 * @date 2020/12/16 20:43
 * @mail wjxScott@163.com
 * @description 剑指offer 01 数组
 */
public class ZJ01 {
    public boolean Find(int target, int[][] array) {
        if (array.length == 0) {
            return false;
        }

        if (array[0].length == 0) {
            return false;
        }

        int start = array[0][0];
        int[] heng = array[array.length - 1];
        int end = heng[heng.length - 1];

        if (target < start || target > end) {
            return false;
        }

        for (int i = 0; i < array.length; i++) {
            boolean b = find(target, array[i]);
            if (b) {
                return b;
            }
        }
        return false;
    }

    public boolean find(int target, int[] array) {
        int start = array[0];
        int end = array[array.length - 1];

        if (target < start || target > end) {
            return false;
        }
        return binarySearch(target, array, 0, array.length - 1);
    }

    public Boolean binarySearch(int target, int[] array, int start, int end) {
        int mid = (start + end) / 2;
        if (start < end) {
            if (target < array[mid]) {
                return binarySearch(target, array, start, mid);
            } else if (target > array[mid]) {
                return binarySearch(target, array, mid + 1, end);
            } else {
                return true;
            }
        } else {
            return array[mid] == target;
        }
    }

    public boolean Find1(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        int column = array[0].length - 1;
        int row = 0;
        while (row < array.length && column >= 0) {
            if (array[row][column] == target) {
                return true;
            }

            if (array[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}
