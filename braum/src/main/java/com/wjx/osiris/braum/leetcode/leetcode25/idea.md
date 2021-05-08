```java
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
```

先通过遍历计算出链表的长度，排除k<长度不需要反转、k=1不需要反转的情况，第二个方法算出每次反转之后的最后一个长度，如果小于长度就满足反转，就变成了反转前k个元素的问题