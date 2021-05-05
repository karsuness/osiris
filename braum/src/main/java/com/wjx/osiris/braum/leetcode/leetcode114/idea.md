```java
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;

        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
```

分别将左右子树进行递归处理，左右子树分别拉成链表，并将左子树的链表最后一个节点链接到右子树的链表的头结点