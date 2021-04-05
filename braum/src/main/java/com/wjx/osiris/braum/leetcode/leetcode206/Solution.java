package com.wjx.osiris.braum.leetcode.leetcode206;

import com.wjx.osiris.braum.leetcode.ListNode;

/**
 * @author wangjinxin
 * @date 2021/4/5 23:16
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }
        ListNode last = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public ListNode reverseList2(ListNode head) {

        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
