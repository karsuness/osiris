package com.wjx.osiris.braum.leetcode;

/**
 * @author wangjinxin
 * @date 2021/5/5 13:45
 * @mail wjxScott@iCloud.com
 * @description
 */
public class TreeNode {

    public Integer val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(Integer val) {
        this.val = val;
    }

    public TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
