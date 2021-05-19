package com.wjx.osiris.braum.leetcode.leetcode354;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wangjinxin
 * @date 2021/5/20 00:08
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;

        //按宽度升序排序，如果宽度一样，则按照高度降序排序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });


        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = envelopes[i][1];
        }

        //对高度数组寻找LIS
        return maxLength(array);
    }

    public int maxLength(int[] array) {
        int[] dp = new int[array.length];

        Arrays.fill(dp, 1);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int result = 0;

        for (int i = 0; i < dp.length; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
