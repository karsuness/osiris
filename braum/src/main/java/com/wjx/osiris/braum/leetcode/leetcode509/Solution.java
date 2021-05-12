package com.wjx.osiris.braum.leetcode.leetcode509;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangjinxin
 * @date 2021/5/12 22:55
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    private Map<Integer, Integer> map = new HashMap<>();

    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int num1 = fib(n - 2);
        map.put(n - 2, num1);

        int num2 = fib(n - 1);
        map.put(n - 1, num2);
        return num1 + num2;
    }
}
