```java
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = this.buildBinary(nums, 0, nums.length);
        return root;
    }

    private TreeNode buildBinary(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }

        int index = -1;
        int maxVal = Integer.MIN_VALUE;

        for (int i = start; i < end; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(maxVal);
        root.left = buildBinary(nums, start, index);
        root.right = buildBinary(nums, index + 1, end);
        return root;
    }
}
```

这里构建二叉树可以通过递归的方式分别构建左右子树，只需要找到最大值将数组进行分割之后递归处理即可