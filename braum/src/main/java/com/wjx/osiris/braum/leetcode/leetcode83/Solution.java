package com.wjx.osiris.braum.leetcode.leetcode83;

import com.wjx.osiris.braum.leetcode.ListNode;

/**
 * @author wangjinxin
 * @date 2021/4/7 0:45
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null) {
            if (slow.val == fast.val) {
                slow.next = fast.next;
                fast.next = null;
                fast = slow.next;
            } else {
                slow = fast;
                fast = fast.next;
            }
        }
        return head;
    }
}
