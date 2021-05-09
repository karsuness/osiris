package com.wjx.osiris.braum.leetcode.leetcode236;

import com.wjx.osiris.braum.leetcode.TreeNode;

/**
 * @author wangjinxin
 * @date 2021/5/9 17:30
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left == null && right == null) {
            return null;
        }

        return left == null ? right : left;
    }
}
