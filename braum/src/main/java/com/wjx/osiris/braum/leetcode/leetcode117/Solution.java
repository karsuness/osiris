package com.wjx.osiris.braum.leetcode.leetcode117;

import com.wjx.osiris.braum.leetcode.Node;

/**
 * @author wangjinxin
 * @date 2021/5/6 17:26
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        if (root.left != null) {
            root.left.next = root.right != null ? root.right : getNextNode(root.next);
        }

        if (root.right != null) {
            root.right.next = getNextNode(root.next);
        }

        connect(root.right);
        connect(root.left);

        return root;
    }

    private Node getNextNode(Node node) {
        if (node == null) {
            return null;
        }

        if (node.left != null) {
            return node.left;
        }

        if (node.right != null) {
            return node.right;
        }

        return getNextNode(node.next);
    }
}
