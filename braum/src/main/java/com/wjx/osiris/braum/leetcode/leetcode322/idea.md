```java
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

```

本题属于动态规划，我们可以加个问题进行拆解，通过遍历数组来对问题进行拆解，通过改变凑齐的进行进行递归来计算出所有的结果，并获得最优解，通过map来存放结果进行剪枝，避免重复计算