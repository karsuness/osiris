package com.wjx.osiris.braum.leetcode.leetcode242;

import java.util.Arrays;

/**
 * @author wangjinxin
 * @date 2021/4/8 1:32
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}
