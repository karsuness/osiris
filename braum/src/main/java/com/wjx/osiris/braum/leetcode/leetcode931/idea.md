```java
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

```

动态规划题，使用数组来进行剪枝处理重复子问题。我们从最后一行开始，开始最后一行每个元素都有可能被选择，后面计算上一行可能的三个元素，注意边界问题