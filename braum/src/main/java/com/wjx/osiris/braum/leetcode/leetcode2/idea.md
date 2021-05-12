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

```java
public class Solution {
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

```

解法二使用了递归，构建了一个辅助类，思路与解法一相同