```java
public class Solution {
    List<Integer> list;

    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        reverse(root);
        return list;
    }

    private void reverse(TreeNode root) {
        if (root == null) {
            return;
        }

        reverse(root.left);
        list.add(root.val);
        reverse(root.right);
    }
}
```

普通二叉树中序遍历，使用list保存遍历的结果