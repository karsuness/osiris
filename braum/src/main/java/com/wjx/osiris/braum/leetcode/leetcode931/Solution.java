package com.wjx.osiris.braum.leetcode.leetcode931;

import java.util.Arrays;

/**
 * @author wangjinxin
 * @date 2021/5/16 18:42
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;

        int[][] memo = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], 66666);
        }

        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp(matrix, memo, n - 1, i));
        }
        return min;
    }

    private int dp(int[][] matrix, int[][] memo, int x, int y) {
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[x].length) {
            return 99999;
        }

        if (x == 0) {
            return matrix[0][y];
        }

        if (memo[x][y] != 66666) {
            return memo[x][y];
        }

        int result = matrix[x][y]
                + min(dp(matrix, memo, x - 1, y - 1), dp(matrix, memo, x - 1, y), dp(matrix, memo, x - 1, y + 1));
        memo[x][y] = result;
        return result;
    }

    private int min(int num1, int num2, int num3) {
        return Math.min(num1, Math.min(num2, num3));
    }
}
