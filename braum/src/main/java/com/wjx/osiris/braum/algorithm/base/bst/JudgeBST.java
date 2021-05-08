package com.wjx.osiris.braum.algorithm.base.bst;

import com.wjx.osiris.braum.algorithm.base.tree.TreeNode;

/**
 * @author wangjinxin
 * @date 2021/5/8 15:26
 * @mail wjxScott@iCloud.com
 * @description 判断是否为BST
 */
public class JudgeBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val
     */
    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        // base case
        if (root == null) {
            return true;
        }
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != null && root.value <= min.value) {
            return false;
        }
        if (max != null && root.value >= max.value) {
            return false;
        }
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }
}
