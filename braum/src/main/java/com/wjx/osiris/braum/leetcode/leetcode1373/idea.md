```java
public class Solution {
    private int sum = 0;

    public int maxSumBST(TreeNode root) {
        reverse(root);
        return sum;
    }

    private int[] reverse(TreeNode root) {
        if (root == null) {
            return new int[]{1, Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }

        //递归计算左右子树
        int[] left = reverse(root.left);
        int[] right = reverse(root.right);

        //后续遍历位置
        int[] result = new int[4];

        //这个if判断以root为根的二叉树是不是BST
        if (left[0] == 1 && right[0] == 1 && root.val > left[1] && root.val < right[2]) {
            //该节点为根的树为二叉搜索树
            result[0] = 1;
            //计算以root为根的这棵树BST的最小值
            result[1] = Math.max(right[1], root.val);
            //计算以root为根的这棵树BST的最大值
            result[2] = Math.min(left[2], root.val);
            //计算以root为根的的这棵BST的所有节点之和
            result[3] = left[3] + right[3] + root.val;
            sum = Math.max(sum, result[3]);
        } else {
            result[0] = 0;
        }
        return result;
    }
}

```

二叉树相关题目最核心的思路是明确当前节点需要做的事情是什么。

那么我们想计算子树中 BST 的最大和，站在当前节点的视角，需要做什么呢？

1、我肯定得知道左右子树是不是合法的 BST，如果这俩儿子有一个不是 BST，以我为根的这棵树肯定不会是 BST，对吧。

2、如果左右子树都是合法的 BST，我得瞅瞅左右子树加上自己还是不是合法的 BST 了。因为按照 BST 的定义，当前节点的值应该大于左子树的最大值，小于右子树的最小值，否则就破坏了 BST 的性质。

3、因为题目要计算最大的节点之和，如果左右子树加上我自己还是一棵合法的 BST，也就是说以我为根的整棵树是一棵 BST，那我需要知道我们这棵 BST 的所有节点值之和是多少，方便和别的 BST 争个高下，对吧。

根据以上三点，站在当前节点的视角，需要知道以下具体信息：

1、左右子树是否是 BST。

2、左子树的最大值和右子树的最小值。

3、左右子树的节点值之和。

只有知道了这几个值，我们才能满足题目的要求，后面我们会想方设法计算这些值。

traverse(root) 返回一个大小为 4 的 int 数组，我们暂且称它为 res，其中：

res[0] 记录以 root 为根的二叉树是否是 BST，若为 1 则说明是 BST，若为 0 则说明不是 BST；

res[1] 记录以 root 为根的二叉树所有节点中的最大值；

res[2] 记录以 root 为根的二叉树所有节点中的最小值；

res[3] 记录以 root 为根的二叉树所有节点值之和。