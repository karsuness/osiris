package com.wjx.osiris.braum.leetcode.leetcode105;

import com.wjx.osiris.braum.leetcode.TreeNode;

/**
 * @author wangjinxin
 * @date 2021/5/5 18:41
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = build(preorder, 0, preorder.length, inorder, 0, inorder.length);
        return root;
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart >= preEnd) {
            return null;
        }

        int rootNum = preorder[preStart];

        int index = -1;

        for (int i = inStart; i < inEnd; i++) {
            if (rootNum == inorder[i]) {
                index = i;
                break;
            }
        }

        int leftSize = index - inStart;

        TreeNode root = new TreeNode(rootNum);
        root.left = build(preorder, preStart + 1, preStart + leftSize + 1, inorder, inStart, index);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }
}
