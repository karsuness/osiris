package com.wjx.heimerdinger.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author wangjinxin
 * @date 2020/12/17 21:07
 * @mail wjxScott@iCloud.com
 * @description 剑指offer03 链表反转
 */
public class ZJ03 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<Integer>();
        }


        Stack<Integer> stack = new Stack<>();
        while (listNode.next != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        //还有最后一个
        ArrayList<Integer> arrayList = new ArrayList<>(stack.size() + 1);
        arrayList.add(listNode.val);
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }


    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
