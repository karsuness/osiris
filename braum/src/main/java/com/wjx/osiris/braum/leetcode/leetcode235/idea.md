```java
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = root;
        while (true) {
            if (result.val > p.val && result.val > q.val) {
                result = lowestCommonAncestor(root.left, p, q);
            } else if (result.val < p.val && result.val < q.val) {
                result = lowestCommonAncestor(root.right, p, q);
            } else {
                break;
            }
        }
        return result;
    }
}
```

根据二叉搜索树的特性根节点大于左子树的所有节点，小于右子树的所有节点。当根节点的值大于两个目标值则说明目标节点在左子树，同理小于的情况下在右子树。否则说明在左右子树中，那么这个就是公共节点