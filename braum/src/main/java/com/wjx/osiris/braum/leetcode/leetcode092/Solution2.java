package com.wjx.osiris.braum.leetcode.leetcode092;

import com.wjx.osiris.braum.leetcode.ListNode;

/**
 * @author wangjinxin
 * @date 2021/4/24 21:26
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverse(head, right);
        }

        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }


    private ListNode reverse(ListNode node, int m) {
        ListNode successor = null;
        if (m == 1) {
            successor = node.next;
            return node;
        }
        ListNode lastNode = reverse(node.next, m - 1);
        node.next.next = node;
        node.next = successor;
        return lastNode;
    }
}
