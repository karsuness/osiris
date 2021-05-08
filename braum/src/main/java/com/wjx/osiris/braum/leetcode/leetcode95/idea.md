```java
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return build(1, n);
    }

    private List<TreeNode> build(int start, int end) {
        List<TreeNode> result = new LinkedList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = build(start, i - 1);
            List<TreeNode> rightTree = build(i + 1, end);

            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
```

本题也是利用递归的方式来进行穷举，每次都使用不用元素来作为头结点进行穷举，将所有结果放入list中