```java
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
```

使用快慢指针，当快指针到达null时结束。如果两个指针的值相等去除快指针的这个节点并开始下一轮循环，否则两个指针同时前进