package com.wjx.osiris.braum.leetcode.leetcode21;

import com.wjx.osiris.braum.leetcode.ListNode;

/**
 * @author wangjinxin
 * @date 2021/3/28 12:19
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
