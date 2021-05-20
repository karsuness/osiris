```java
public class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < dp.length; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
```

https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485355&idx=1&sn=17a59704a657b4880dffb54c40ad730e&chksm=9bd7f9a3aca070b53c3f74c9d0a1074ae1e615699fd3b977b8134d486106e62fb28cdf59cb52&scene=21#wechat_redirect