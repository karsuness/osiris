package com.wjx.osiris.braum.leetcode.leetcode96;

/**
 * @author wangjinxin
 * @date 2021/5/8 17:54
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {

    int[][] demo;

    public int numTrees(int n) {
        demo = new int[n + 1][n + 1];
        return count(1, n);
    }

    private int count(int start, int end) {
        if (start > end) {
            return 1;
        }

        if (demo[start][end] != 0) {
            return demo[start][end];
        }

        int result = 0;
        for (int i = start; i <= end; i++) {
            int left = count(start, i - 1);
            int right = count(i + 1, end);
            result += left * right;
        }

        demo[start][end] = result;
        return result;
    }
}
