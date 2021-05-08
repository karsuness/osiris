package com.wjx.osiris.braum.leetcode.leetcode92;

import com.wjx.osiris.braum.leetcode.ListNode;

/**
 * @author wangjinxin
 * @date 2021/4/24 16:29
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        int index = 1;

        ListNode startNode = null;

        if (index != 1) {
            while (index != left - 1) {
                head = head.next;
                index++;
            }
            startNode = head;
            head = head.next;
        }

        ListNode lastNode = reverse(head, left, right);

        if (startNode == null) {
            return lastNode;
        } else {
            startNode.next = lastNode;
            return startNode;
        }
    }

    private ListNode reverse(ListNode node, int start, int end) {
        if (start == end) {
            return node;
        }

        ListNode lastNode = reverse(node.next, ++start, end);
        ListNode tempNode = node.next;
        node.next = tempNode.next;
        tempNode.next = node;
        tempNode = null;
        return lastNode;
    }

}
