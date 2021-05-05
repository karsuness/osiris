package com.wjx.osiris.braum.leetcode.leetcode226;

import com.wjx.osiris.braum.leetcode.TreeNode;

/**
 * @author wangjinxin
 * @date 2021/5/5 13:50
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        TreeNode temp = left;
        root.left = right;
        root.right = temp;
        temp = null;
        return root;
    }
}
