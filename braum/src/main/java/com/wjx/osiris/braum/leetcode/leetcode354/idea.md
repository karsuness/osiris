```java
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

```

https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484494&idx=1&sn=0e90d7fbf812fd1f4c408b5cc5fdf8c6&chksm=9bd7fa46aca07350f626e2365d9f71545aa304725b7122b5a44bcfd90cf0506c9036201f3b38&scene=21#wechat_redirect
