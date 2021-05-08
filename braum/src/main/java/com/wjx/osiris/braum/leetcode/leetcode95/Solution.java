package com.wjx.osiris.braum.leetcode.leetcode95;

import com.wjx.osiris.braum.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wangjinxin
 * @date 2021/5/8 20:24
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return build(1, n);
    }

    private List<TreeNode> build(int start, int end) {
        List<TreeNode> result = new LinkedList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = build(start, i - 1);
            List<TreeNode> rightTree = build(i + 1, end);

            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
