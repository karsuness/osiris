package com.wjx.osiris.braum.leetcode.leetcode297;

import com.wjx.osiris.braum.leetcode.TreeNode;

import java.util.LinkedList;

/**
 * @author wangjinxin
 * @date 2021/5/9 13:09
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Codec {

    private String NULL_STR = "null";

    private String SPLIT = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeReverse(root, sb);
        return sb.toString();
    }

    public void serializeReverse(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL_STR).append(SPLIT);
            return;
        }

        sb.append(root.val).append(SPLIT);
        serializeReverse(root.left, sb);
        serializeReverse(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(SPLIT);
        LinkedList<String> nodeList = new LinkedList<>();
        for (String str : strs) {
            nodeList.add(str);
        }
        return deserializeReverse(nodeList);
    }


    public TreeNode deserializeReverse(LinkedList<String> nodeList) {
        if (nodeList.isEmpty()) {
            return null;
        }

        String s = nodeList.removeFirst();

        if (s.equals(NULL_STR)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(s));

        root.left = deserializeReverse(nodeList);
        root.right = deserializeReverse(nodeList);
        return root;
    }
}
