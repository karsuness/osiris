package com.wjx.osiris.braum.leetcode.leetcode1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangjinxin
 * @date 2021/3/23 23:39
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (map.containsKey(value)) {
                return new int[]{map.get(value), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }
}
