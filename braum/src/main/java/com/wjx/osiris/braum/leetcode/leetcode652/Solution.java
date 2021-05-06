package com.wjx.osiris.braum.leetcode.leetcode652;

import com.wjx.osiris.braum.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangjinxin
 * @date 2021/5/6 21:02
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {

    private List<TreeNode> resultList = new ArrayList<>();

    private Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        reverse(root);
        return resultList;
    }

    private String reverse(TreeNode root) {
        if (root == null) {
            return "&";
        }

        String left = reverse(root.left);
        String right = reverse(root.right);

        String str = root.val + "," + left + "," + right;

        Integer num = map.getOrDefault(str, 0);

        if (num == 1) {
            resultList.add(root);
        }

        map.put(str, num + 1);
        return str;
    }
}
