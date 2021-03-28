package com.wjx.osiris.braum.leetcode.leetcode155;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wangjinxin
 * @date 2021/3/28 22:43
 * @mail wjxScott@iCloud.com
 * @description
 */
public class MinStack {

    Stack<Integer> stack;
    List<Integer> list;
    int min;
    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.stack = new Stack<Integer>();
        this.list = new ArrayList<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            min = val;
            stack.push(val);
            list.add(val);
        } else {
            stack.push(val);
            list.add(val);
            min = Math.min(val, min);
        }
    }

    public void pop() {
        int num = stack.pop();
        list.remove((Integer)num);
        if (num == min) {
            min = getMinFromList();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    private int getMinFromList() {
        if (list.size() == 0) {
            return 0;
        }

        int minNum = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            minNum = Math.min(minNum,list.get(i));
        }
        return minNum;
    }
}
