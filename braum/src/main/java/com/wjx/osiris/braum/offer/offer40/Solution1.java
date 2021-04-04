package com.wjx.osiris.braum.offer.offer40;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wangjinxin
 * @date 2021/4/3 21:36
 * @mail wjxScott@163.com
 * @description 使用堆
 */
public class Solution1 {
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == k) {
            return arr;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(k, Comparator.reverseOrder());

        for (int i = 0; i < k; i++) {
            priorityQueue.add(arr[i]);
        }

        for (int j = k; j < arr.length; j++) {
            if (arr[j] < priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.add(arr[j]);
            }
        }

        int[] nums = new int[k];

        for (int i = 0; i < k; i++) {
            nums[i] = priorityQueue.poll();
        }

        return nums;
    }
}
