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

首先当两个数相等时不需要反转节点，直接返回即可，如果不相等判断一下要反转的起点是不是第一个节点，如果是第一个节点直接返回反转之后的头结点，如果不是需要记录反装之前的节点将反转的节点连接到记录的节点后面

```java
class Solution {
    ListNode successor = null;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }

        if (left == 1) {
            return reverse(head, right);
        }

        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    private ListNode reverse(ListNode node, int m) {
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
```

定义的子方法是反转前m个元素的链表，我们找到第m个节点之后的节点作为每个节点的最后一个节点，每次都要将节点指向这个节点。最后完成前m个元素的反转。当反转区间的起点为1时就刚好是这种情况。如果不是一的话我们就考虑这个问题：我们认为第一个节点是1，那么反转的是m,n之间的节点，如果以第二个节点为1，那么反转的是m-1,n-1个节点，以此类推如果以第m个节点为1，那么反转的就是1到n-m之间的节点这样就回到刚才的情况。而这段时间的递归只需要将结果放到刚才节点的下一位即可