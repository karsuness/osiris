```java
public class Codec {

    private String NULL_STR = "null";

    private String SPLIT = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeReverse(root, sb);
        return sb.toString();
    }

    public void serializeReverse(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL_STR).append(SPLIT);
            return;
        }

        sb.append(root.val).append(SPLIT);
        serializeReverse(root.left, sb);
        serializeReverse(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(SPLIT);
        LinkedList<String> nodeList = new LinkedList<>();
        for (String str : strs) {
            nodeList.add(str);
        }
        return deserializeReverse(nodeList);
    }


    public TreeNode deserializeReverse(LinkedList<String> nodeList) {
        if (nodeList.isEmpty()) {
            return null;
        }

        String s = nodeList.removeFirst();

        if (s.equals(NULL_STR)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(s));

        root.left = deserializeReverse(nodeList);
        root.right = deserializeReverse(nodeList);
        return root;
    }
}
```

本题中序列化只要是各种遍历并将遍历的结果放入到结果集中，使用stringbuffer来存放结果，在反序列化中，先将string转成list，遍历list，但是注意，在序列化中我们使用先序遍历，那么list的第一个元素就是头结点