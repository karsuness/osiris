```java
public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }

    private void connectTwoNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }

        node1.next = node2;
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        //同一层不同父节点的进行连接
        connectTwoNode(node1.right, node2.left);
    }
}
```

本题的难点主要是在同一层但是不是同一个父节点的两个节点的连接问题，这里我们发现一个节点的左孩子的右节点和右孩子的左节点刚好是刚才问题的点，这时我们在递归的过程中将这种情况也放到递归的过程中就可以连接这个问题