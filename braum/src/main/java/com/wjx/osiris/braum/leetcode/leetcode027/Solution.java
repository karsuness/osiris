package com.wjx.osiris.braum.leetcode.leetcode027;

/**
 * @author liusha
 * @date 2021/3/28 22:05
 * @mail liusha@wacai.com
 * @description
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
