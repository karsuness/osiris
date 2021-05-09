package com.wjx.osiris.braum.leetcode.leetcode222;

import com.wjx.osiris.braum.leetcode.TreeNode;

/**
 * @author wangjinxin
 * @date 2021/5/9 20:30
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    public int countNodes(TreeNode root) {
        int lh = 0;
        int rh = 0;

        TreeNode left = root;
        TreeNode right = root;

        while (left != null) {
            left = left.left;
            lh++;
        }

        while (right != null) {
            right = right.right;
            rh++;
        }

        if (lh == rh) {
            return (int) Math.pow((double) 2, (double) lh) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
