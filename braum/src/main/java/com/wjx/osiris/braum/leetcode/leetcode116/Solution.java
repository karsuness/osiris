package com.wjx.osiris.braum.leetcode.leetcode116;

import com.wjx.osiris.braum.leetcode.Node;

/**
 * @author wangjinxin
 * @date 2021/5/5 14:33
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }

    private void connectTwoNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }

        node1.next = node2;
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        //同一层不同父节点的进行连接
        connectTwoNode(node1.right, node2.left);
    }
}
