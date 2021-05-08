package com.wjx.osiris.braum.leetcode.leetcode230;

import com.wjx.osiris.braum.leetcode.TreeNode;

/**
 * @author wangjinxin
 * @date 2021/5/8 12:49
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {

    private int rank;

    private int result;

    public int kthSmallest(TreeNode root, int k) {
        reverse(root, k);
        return result;
    }

    private void reverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        reverse(root.left, k);
        rank++;
        if (rank == k) {
            result = root.val;
            return;
        }
        reverse(root.right, k);
    }
}