package com.wjx.osiris.braum.leetcode.leetcode013;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liusha
 * @date 2021/3/27 13:29
 * @mail liusha@wacai.com
 * @description
 */
public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] array = s.toCharArray();

        int preElement = map.get(array[0]);
        int sum = 0;

        for (int i = 1; i < array.length; i++) {
            int element = map.get(array[i]);

            if (element > preElement) {
                sum -= preElement;
            } else {
                sum += preElement;
            }
            preElement = element;
        }
        sum += preElement;
        return sum;
    }
}
