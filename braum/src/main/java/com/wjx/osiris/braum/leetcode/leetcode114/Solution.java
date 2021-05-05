package com.wjx.osiris.braum.leetcode.leetcode114;

import com.wjx.osiris.braum.leetcode.TreeNode;

/**
 * @author wangjinxin
 * @date 2021/5/5 16:31
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;

        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
