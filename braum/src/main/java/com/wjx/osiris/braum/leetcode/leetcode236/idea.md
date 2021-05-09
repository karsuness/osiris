```java
public class Solution {

    private TreeNode node = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        reverse(root, p, q);
        return node;
    }

    private boolean reverse(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        boolean left = reverse(root.left, p, q);
        boolean right = reverse(root.right, p, q);

        if ((left && right) || ((left || right) && (root == p || root == q))) {
            node = root;
        }
        return (left || right) || (root == p || root == q);
    }
}

```

解法一：这个方法判断节点是否在与目标节点相等，如果子节点中存在并且本节点也与目标节点相等则该节点为最终结果

```java
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left == null && right == null) {
            return null;
        }

        return left == null ? right : left;
    }
}
```

解法二：该方法分析了三种情况。

- 如果p和q都在以root为根的树中，那么left和right一定是p和q。
- 如果p和q都不在以root为根的树中，直接返回null
- 如果p和q只有一个存在于root为根的树中，函数返回该节点