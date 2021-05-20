package com.wjx.osiris.braum.leetcode.leetcode53;

/**
 * @author wangjinxin
 * @date 2021/5/20 22:03
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < dp.length; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
