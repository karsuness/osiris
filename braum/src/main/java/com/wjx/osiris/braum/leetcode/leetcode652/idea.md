```java
public class Solution {

    private List<TreeNode> resultList = new ArrayList<>();

    private Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        reverse(root);
        return resultList;
    }

    private String reverse(TreeNode root) {
        if (root == null) {
            return "&";
        }

        String left = reverse(root.left);
        String right = reverse(root.right);

        String str = root.val + "," + left + "," + right;

        Integer num = map.getOrDefault(str, 0);

        if (num == 1) {
            resultList.add(root);
        }

        map.put(str, num + 1);
        return str;
    }
}
```

本题可以用每个节点遍历之后将结果放入map中一旦map中key重合就表示已经存在，将结果放入到list中，由于需要知道左右子树的序列需要使用后序遍历的方式