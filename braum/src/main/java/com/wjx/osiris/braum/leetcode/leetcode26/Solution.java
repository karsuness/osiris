package com.wjx.osiris.braum.leetcode.leetcode26;

/**
 * @author wangjinxin
 * @date 2021/3/28 21:14
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
