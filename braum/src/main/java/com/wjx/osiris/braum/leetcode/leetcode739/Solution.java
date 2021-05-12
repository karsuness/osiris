package com.wjx.osiris.braum.leetcode.leetcode739;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangjinxin
 * @date 2021/5/12 23:42
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[temperatures.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= stack.peek()) {
                stack.pop();
            }

            int maxTemp = stack.isEmpty() ? -1 : stack.peek();

            if (maxTemp == -1) {
                result[i] = 0;
            } else {
                Integer day = map.get(maxTemp);
                result[i] = day - i;
            }
            stack.push(temperatures[i]);
            map.put(temperatures[i], i);
        }
        return result;
    }
}
