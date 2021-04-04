package com.wjx.osiris.braum.algorithm.base.linkednode;

/**
 * @author wangjinxin
 * @date 2021/4/4 21:49
 * @mail wjxScott@iCloud.com
 * @description 反转链表方式
 */
public class ReverseList {

    /**
     * 每次判断节点是否为最后一个节点并改变节点的指向
     *
     * @param head
     * @return
     */
    public LinkedNode reverseList1(LinkedNode head) {
        LinkedNode pre = null;

        LinkedNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    /**
     * 递归方式反转
     *
     * @param head
     * @return
     */
    public LinkedNode reverserList2(LinkedNode head) {
        if (head.next == null) {
            return head;
        }

        LinkedNode last = reverserList2(head.next);

        head.next.next = head;
        head.next = null;
        return last;
    }


    LinkedNode result = null;

    /**
     * 反转前n个元素
     *
     * @param head
     * @param n
     * @return
     */
    public LinkedNode reverseListN(LinkedNode head, Integer n) {
        if (n == 1) {
            result = head.next;
            return head;
        }
        LinkedNode last = reverseListN(head.next, n - 1);

        head.next.next = head;
        head.next = result;
        return last;
    }

    /**
     * 反转 m-m个数
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    LinkedNode reverseBetween(LinkedNode head, int m, int n) {
        if (m == 1) {
            return reverseListN(head, n);
        }

        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
}
