package com.wjx.osiris.braum.leetcode.leetcode003;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liusha
 * @date 2021/5/4 20:25
 * @mail liusha@wacai.com
 * @description
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = 0;

        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            map.put(s.charAt(j), j);
            length = Math.max(length, j - i + 1);
        }
        return length;
    }
}
