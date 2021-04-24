```java
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
```

首先当两个数相等时不需要反装节点，直接返回即可，如果不相等判断一下要反转的起点是不是第一个节点，如果是第一个节点直接返回反转之后的头结点，如果不是需要记录反装之前的节点将反转的节点连接到记录的节点后面


