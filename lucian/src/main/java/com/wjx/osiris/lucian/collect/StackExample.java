package com.wjx.osiris.lucian.collect;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author wangjinxin
 * @date 2021/4/5 13:49
 * @mail wjxScott@iCloud.com
 * @description
 */
public class StackExample {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println("---------------------------------------------------------");

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
//        arrayDeque.offer(1);
//        arrayDeque.offer(2);
//        arrayDeque.offer(3);
//        arrayDeque.offer(4);
//        arrayDeque.offer(5);
//
        arrayDeque.push(1);
        arrayDeque.push(2);
        arrayDeque.push(3);
        arrayDeque.push(4);
        arrayDeque.push(5);

        while (arrayDeque.peek() != null) {
            System.out.println(arrayDeque.poll());
        }
    }
}
