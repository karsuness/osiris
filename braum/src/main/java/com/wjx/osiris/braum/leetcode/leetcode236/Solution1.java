package com.wjx.osiris.braum.leetcode.leetcode236;

import com.wjx.osiris.braum.leetcode.TreeNode;

/**
 * @author wangjinxin
 * @date 2021/5/9 17:30
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution1 {

    private TreeNode node = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        reverse(root, p, q);
        return node;
    }

    private boolean reverse(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        boolean left = reverse(root.left, p, q);
        boolean right = reverse(root.right, p, q);

        if ((left && right) || ((left || right) && (root == p || root == q))) {
            node = root;
        }
        return (left || right) || (root == p || root == q);
    }
}
