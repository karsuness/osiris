```java
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

```

本题的主要逻辑是穷举出全部的方式，用每个节点作为头结点进行穷举，同时利用一个数组保存已有的数据来减少重复的计算