package com.wjx.osiris.braum.leetcode.leetcode001;

import java.util.HashMap;

/**
 * @author wangjinxin
 * @date 2021/3/23 23:39
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int arg1 = target - nums[i];
            if (map.get(arg1) != null && map.get(arg1) != i) {
                result[0] = i;
                result[1] = map.get(arg1);
                break;
            }
        }
        return result;
    }
}
