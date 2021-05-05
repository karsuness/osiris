```java
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        TreeNode temp = left;
        root.left = right;
        root.right = temp;
        temp = null;
        return root;
    }
}
```

使用递归的方式处理每个子孩子处理完成之后再交换左右孩子节点即可