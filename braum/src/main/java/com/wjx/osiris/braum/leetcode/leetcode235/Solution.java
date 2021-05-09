package com.wjx.osiris.braum.leetcode.leetcode235;

import com.wjx.osiris.braum.leetcode.TreeNode;

/**
 * @author wangjinxin
 * @date 2021/5/9 19:30
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = root;
        while (true) {
            if (result.val > p.val && result.val > q.val) {
                result = lowestCommonAncestor(root.left, p, q);
            } else if (result.val < p.val && result.val < q.val) {
                result = lowestCommonAncestor(root.right, p, q);
            } else {
                break;
            }
        }
        return result;
    }
}
