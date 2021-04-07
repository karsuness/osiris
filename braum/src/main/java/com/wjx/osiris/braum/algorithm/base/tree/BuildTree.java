package com.wjx.osiris.braum.algorithm.base.tree;

/**
 * @author wangjinxin
 * @date 2021/4/8 1:04
 * @mail wjxScott@iCloud.com
 * @description 根据输入的中序遍历和后续遍历的数组还原二叉树
 */
public class BuildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {

        if (inStart > inEnd) {
            return null;
        }

        //后序遍历的最后一个节点就是根节点
        int rootValue = postorder[postEnd];
        //查找根节点在中序遍历中的坐标
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                index = i;
                break;
            }
        }

        //左子树长度
        int leftSize = index - inStart;

        TreeNode root = new TreeNode(rootValue);
        root.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
        return root;
    }
}
