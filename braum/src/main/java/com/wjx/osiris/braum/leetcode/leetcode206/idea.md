```java
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }

        if(head.next == null){
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
```

方法一：使用递归的方式找到最后一个节点，一次反向将指针旋转

```java
public class Solution {
    public ListNode reverseList(ListNode head){
        
        ListNode pre = null;
        ListNode next = null;
        
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
```

方法二：使用迭代的方式，每次将节点与前一个节点进行交换