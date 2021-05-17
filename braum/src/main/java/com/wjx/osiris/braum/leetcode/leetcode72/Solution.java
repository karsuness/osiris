package com.wjx.osiris.braum.leetcode.leetcode72;

import java.util.Arrays;

/**
 * @author wangjinxin
 * @date 2021/5/18 00:54
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];

        for (int i = 0; i < word1.length(); i++) {
            Arrays.fill(memo[i], -1);
        }

        return dp(memo, word1, word2, word1.length() - 1, word2.length() - 1);
    }

    public int dp(int[][] memo, String word1, String word2, int i, int j) {
        if (i == -1) {
            return j + 1;
        }

        if (j == -1) {
            return i + 1;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int minResult;
        if (word1.charAt(i) == word2.charAt(j)) {
            minResult = dp(memo, word1, word2, i - 1, j - 1);
        } else {
            minResult = min(dp(memo, word1, word2, i, j - 1) + 1, dp(memo, word1, word2, i - 1, j)
                    + 1, dp(memo, word1, word2, i - 1, j - 1) + 1);
        }
        memo[i][j] = minResult;
        return minResult;
    }

    private int min(int num1, int num2, int num3) {
        return Math.min(num1, Math.min(num2, num3));
    }
}
