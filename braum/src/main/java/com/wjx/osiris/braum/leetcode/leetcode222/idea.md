```java
public class Solution {
    public int countNodes(TreeNode root) {
        int lh = 0;
        int rh = 0;

        TreeNode left = root;
        TreeNode right = root;

        while (left != null) {
            left = left.left;
            lh++;
        }

        while (right != null) {
            right = right.right;
            rh++;
        }

        if (lh == rh) {
            return (int)Math.pow((double)2, (double)lh) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

```

本题可以使用暴力的遍历来解决但是我们可以利用技巧来处理。首先题目给到的是一个完全二叉树，根据这个特性我们知道，如果如果根节点如果左节点的高度等于右节点的高度那么他就是满二叉树，所有节点都是满的，那么他的节点数量就是2的n次方-1.否则直接判断左右高度计算的结果+1（根节点自己）