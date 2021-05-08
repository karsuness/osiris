package com.wjx.osiris.braum.algorithm.base.bst;


import com.wjx.osiris.braum.algorithm.base.tree.TreeNode;

/**
 * @author wangjinxin
 * @date 2021/5/8 16:01
 * @mail wjxScott@iCloud.com
 * @description 二叉搜索树中查找原数是否存在
 */
public class SearchBST {
    public boolean isInBST(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        if (root.value == target) {
            return true;
        }

        if (root.value < target) {
            return isInBST(root.right, target);
        }

        if (root.value > target) {
            return isInBST(root.left, target);
        }
        return false;
    }
}
