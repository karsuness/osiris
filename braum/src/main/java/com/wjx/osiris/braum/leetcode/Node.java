package com.wjx.osiris.braum.leetcode;

/**
 * @author wangjinxin
 * @date 2021/5/5 14:32
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Node {
    public Integer val;

    public Node left;

    public Node right;

    public Node next;

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
