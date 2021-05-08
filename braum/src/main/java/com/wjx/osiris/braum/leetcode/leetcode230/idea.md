```java
public class Solution {

    private int rank;

    private int result;

    public int kthSmallest(TreeNode root, int k) {
        reverse(root, k);
        return result;
    }

    private void reverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        reverse(root.left, k);
        rank++;
        if (rank == k) {
            result = root.val;
            return;
        }
        reverse(root.right, k);
    }
}
```

二叉搜索树的特性是左子树节点都小于根节点，右子树节点都大于根节点，并且中序遍历的结果是有序的，因此我们使用中序遍历。之后定义一个值，每次遍历的时候自增长，当等于输入的值的时候就可以返回