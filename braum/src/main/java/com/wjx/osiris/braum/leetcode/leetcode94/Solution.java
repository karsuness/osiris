package com.wjx.osiris.braum.leetcode.leetcode94;


import com.wjx.osiris.braum.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangjinxin
 * @date 2021/5/8 20:06
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    List<Integer> list;

    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        reverse(root);
        return list;
    }

    private void reverse(TreeNode root) {
        if (root == null) {
            return;
        }

        reverse(root.left);
        list.add(root.val);
        reverse(root.right);
    }
}
