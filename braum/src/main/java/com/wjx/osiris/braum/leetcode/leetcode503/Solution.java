package com.wjx.osiris.braum.leetcode.leetcode503;

import java.util.Stack;

/**
 * @author wangjinxin
 * @date 2021/3/31 00:43
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length * 2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % nums.length] >= stack.peek()) {
                stack.pop();
            }
            result[i % nums.length] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % nums.length]);
        }
        return result;
    }
}
