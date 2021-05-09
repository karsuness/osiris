package com.wjx.osiris.braum.leetcode.leetcode1373;

import com.wjx.osiris.braum.leetcode.TreeNode;

/**
 * @author wangjinxin
 * @date 2021/5/9 11:25
 * @mail wjxScott@163.com
 * @description 使用result[] 来保存结果，result[0]保存该结果是否为BST 1是 2不是
 * result[1]:数组最大值、
 * result[2]:数组最小值、
 * result[3]:二叉搜索树的最大值
 */
public class Solution {
    private int sum = 0;

    public int maxSumBST(TreeNode root) {
        reverse(root);
        return sum;
    }

    private int[] reverse(TreeNode root) {
        if (root == null) {
            return new int[]{1, Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }

        //递归计算左右子树
        int[] left = reverse(root.left);
        int[] right = reverse(root.right);

        //后续遍历位置
        int[] result = new int[4];

        //这个if判断以root为根的二叉树是不是BST
        if (left[0] == 1 && right[0] == 1 && root.val > left[1] && root.val < right[2]) {
            //该节点为根的树为二叉搜索树
            result[0] = 1;
            //计算以root为根的这棵树BST的最小值
            result[1] = Math.max(right[1], root.val);
            //计算以root为根的这棵树BST的最大值
            result[2] = Math.min(left[2], root.val);
            //计算以root为根的的这棵BST的所有节点之和
            result[3] = left[3] + right[3] + root.val;
            sum = Math.max(sum, result[3]);
        } else {
            result[0] = 0;
        }
        return result;
    }
}
