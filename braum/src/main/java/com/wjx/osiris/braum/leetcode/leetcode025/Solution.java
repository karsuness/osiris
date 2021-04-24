package com.wjx.osiris.braum.leetcode.leetcode025;

import com.wjx.osiris.braum.leetcode.ListNode;

/**
 * @author wangjinxin
 * @date 2021/4/24 22:42
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    ListNode successor = null;

    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        ListNode lengthNode = head;
        while (lengthNode != null) {
            length++;
            lengthNode = lengthNode.next;
        }

        if (length < k || k == 1) {
            return head;
        }

        if (k == length) {
            return reverse(head, k);
        }

        return reverseK(head, k, k, length);
    }

    private ListNode reverseK(ListNode head, int k, int lastIndex, int length) {
        if (lastIndex > length) {
            return head;
        }
        ListNode node = head;
        ListNode firstNode = reverse(head, k);
        node.next = reverseK(node.next, k, lastIndex + k, length);
        return firstNode;
    }

    private ListNode reverse(ListNode head, int k) {
        if (k == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverse(head.next, k - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
