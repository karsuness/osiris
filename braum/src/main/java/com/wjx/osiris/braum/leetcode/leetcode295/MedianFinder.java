package com.wjx.osiris.braum.leetcode.leetcode295;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wangjinxin
 * @date 2021/5/12 00:12
 * @mail wjxScott@iCloud.com
 * @description
 */
public class MedianFinder {

    private PriorityQueue<Integer> maxQueue;
    private PriorityQueue<Integer> minQueue;

    public MedianFinder() {
        maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        minQueue = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxQueue.size() > minQueue.size()) {
            maxQueue.offer(num);
            Integer poll = maxQueue.poll();
            minQueue.offer(poll);
        } else {
            minQueue.offer(num);
            Integer poll = minQueue.poll();
            maxQueue.offer(poll);
        }
    }

    public double findMedian() {
        if (maxQueue.size() == minQueue.size()) {
            return (double) (maxQueue.peek() + minQueue.peek()) / 2;
        } else if (maxQueue.size() > minQueue.size()) {
            return (double) maxQueue.peek();
        } else {
            return (double) minQueue.peek();
        }
    }
}
