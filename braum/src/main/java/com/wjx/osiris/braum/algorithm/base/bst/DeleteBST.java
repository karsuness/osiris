package com.wjx.osiris.braum.algorithm.base.bst;


import com.wjx.osiris.braum.algorithm.base.tree.TreeNode;

/**
 * @author wangjinxin
 * @date 2021/5/8 16:01
 * @mail wjxScott@iCloud.com
 * @description 二叉搜索树中删除一个数
 */
public class DeleteBST {
    public TreeNode deleteBST(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.value == key) {
            //先去除两个只有一个节点的情况
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            //找到右节点中最小的节点
            TreeNode minNode = getMin(root.right);
            root.value = minNode.value;
            root.right = deleteBST(root.right, minNode.value);
        } else if (root.value > key) {
            root.left = deleteBST(root.left, key);
        } else if (root.value < key) {
            root.right = deleteBST(root.right, key);
        }
        return root;
    }

    private TreeNode getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
