```java
public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        Map<String, Integer> memo = new HashMap<>();

        return dp(nums, memo, 0, target);
    }

    private int dp(int[] nums, Map<String, Integer> memo, int n, int rest) {
        if (nums.length == n) {
            if (rest == 0) {
                return 1;
            }
            return 0;
        }

        String key = n + "," + rest;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int result = dp(nums, memo, n + 1, rest - nums[n]) + dp(nums, memo, n + 1, rest + nums[n]);
        memo.put(key, result);
        return result;
    }
}

```

暴力计算出可能的所有结果，由于变量有两个，使用两个变量组合成string存放到map中进行剪枝