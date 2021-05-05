```java
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;

            int sum = num1 + num2 + carry;
            carry = sum / 10;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
```

本题中链表对应的是倒序但是我们输出的结果也是倒序，所以不需要考虑倒序问题，只需要每位直接相加即可，但是这里要考虑的是两边位数不同的问题，当我们发现位数不同时通过判空和用0来取代这个数字的方式来继续计算，但是要注意进位，以及最后如果有进位需要多创建一个节点来存放结果
