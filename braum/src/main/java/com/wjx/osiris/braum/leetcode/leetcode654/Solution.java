package com.wjx.osiris.braum.leetcode.leetcode654;

import com.wjx.osiris.braum.leetcode.TreeNode;

/**
 * @author wangjinxin
 * @date 2021/5/5 18:13
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = this.buildBinary(nums, 0, nums.length);
        return root;
    }

    private TreeNode buildBinary(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }

        int index = -1;
        int maxVal = Integer.MIN_VALUE;

        for (int i = start; i < end; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(maxVal);
        root.left = buildBinary(nums, start, index);
        root.right = buildBinary(nums, index + 1, end);
        return root;
    }
}
