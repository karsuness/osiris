```java
public class Solution {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        getSubTreeNum(root);
        return root;
    }

    private void getSubTreeNum(TreeNode root) {
        if (root == null) {
            return;
        }

        getSubTreeNum(root.right);

        sum += root.val;
        root.val = sum;

        getSubTreeNum(root.left);
    }
}
```

根据二叉搜索树中序遍历的结果是从小到大的顺序我们反向遍历一下这个二叉搜索树，这样每次都是从最右边开始遍历，使用一个sum变量记录一下之前的累加结果并加上本次的值之后赋值给这个节点的val