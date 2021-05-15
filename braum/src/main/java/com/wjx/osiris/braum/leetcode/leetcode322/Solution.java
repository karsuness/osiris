package com.wjx.osiris.braum.leetcode.leetcode322;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangjinxin
 * @date 2021/5/16 00:10
 * @mail wjxScott@iCloud.com
 * @description
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> map = new HashMap<>();
        return getCoin(coins, amount, map);
    }

    public int getCoin(int[] coins, int amount, Map<Integer, Integer> map) {
        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        if (map.containsKey(amount)) {
            return map.get(amount);
        }

        int minResult = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int result = getCoin(coins, amount - coins[i], map);
            if (result == -1) {
                continue;
            }

            minResult = Math.min(minResult, result + 1);
        }

        int returnResult = minResult == Integer.MAX_VALUE ? -1 : minResult;
        map.put(amount, returnResult);
        return returnResult;
    }
}
