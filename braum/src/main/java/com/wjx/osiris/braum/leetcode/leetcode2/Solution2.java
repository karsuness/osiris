package com.wjx.osiris.braum.leetcode.leetcode2;

import com.wjx.osiris.braum.leetcode.ListNode;

/**
 * @author wangjinxin
 * @date 2021/5/12 22:13
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    private ListNode add(ListNode l1, ListNode l2, int carry) {
        int num = 0;
        if (l1 == null && l2 == null) {
            return carry == 0 ? null : new ListNode(carry);
        }

        if (l1 != null && l2 != null) {
            num = l1.val + l2.val + carry;
        } else if (l1 != null) {
            num = l1.val + carry;
        } else if (l2 != null) {
            num = l2.val + carry;
        }

        ListNode root = new ListNode(num % 10);

        if (l1 != null) {
            l1 = l1.next;
        }
        if (l2 != null) {
            l2 = l2.next;
        }
        root.next = add(l1, l2, num / 10);
        return root;
    }
}
