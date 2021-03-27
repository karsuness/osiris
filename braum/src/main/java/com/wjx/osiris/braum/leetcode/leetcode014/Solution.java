package com.wjx.osiris.braum.leetcode.leetcode014;

/**
 * @author liusha
 * @date 2021/3/27 16:33
 * @mail liusha@wacai.com
 * @description
 */
public class Solution {
    public  String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        String first = strs[0];

        StringBuffer sb = new StringBuffer("");
        char[] array = first.toCharArray();

        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            for (int j = 1; j < strs.length; j++) {
                String match = strs[j];
                if (match.length() <= i || c != match.charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
