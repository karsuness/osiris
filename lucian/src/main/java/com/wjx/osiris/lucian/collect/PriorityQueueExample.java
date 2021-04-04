package com.wjx.osiris.lucian.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author liusha
 * @date 2021/4/2 17:27
 * @mail liusha@wacai.com
 * @description
 */
public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>();
//        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>((o1,o2)->o2.compareTo(o1));
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(Comparator.reverseOrder());

        int[] nums = new int[]{5, 7, 1, 3, 9, 52, 4, 11, 60};

        for (int num : nums) {
            priorityQueue1.offer(num);
            priorityQueue2.offer(num);
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(priorityQueue1.poll());
        }

        System.out.println("------------------------------");

        for (int i = 0; i < nums.length; i++) {
            System.out.println(priorityQueue2.poll());
        }
    }
}
