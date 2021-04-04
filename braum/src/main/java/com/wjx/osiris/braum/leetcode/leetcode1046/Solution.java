package com.wjx.osiris.braum.leetcode.leetcode1046;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wangjinxin
 * @date 2021/4/3 21:35
 * @mail wjxScott@163.com
 * @description
 */
public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : stones) {
            priorityQueue.add(num);
        }

        while (priorityQueue.size() > 0) {
            if (priorityQueue.size() == 1) {
                return priorityQueue.poll();
            }

            int result = priorityQueue.poll() - priorityQueue.poll();

            if (result != 0) {
                priorityQueue.add(result);
            }
        }
        return 0;
    }
}
