package com.wjx.osiris.braum.leetcode.leetcode20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author wangjinxin
 * @date 2021/3/27 19:35
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    public static boolean isValid(String s) {
        int length = s.length();
        if (length % 2 == 1) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>(3);
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty()||map.get(c) != stack.peek()) {
                    return false;
                }else{
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
