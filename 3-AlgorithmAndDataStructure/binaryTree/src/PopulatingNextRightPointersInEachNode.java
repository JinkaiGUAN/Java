import java.util.Queue;
import java.util.LinkedList;

/**
 * @author: Peter
 * @date: 19/01/2022
 * @description: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulatingNextRightPointersInEachNode {
    public class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.next = null;
        }

        public Node (int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    Node last = null;
    Node nextStart = null;

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;

            for (int i = 0;  i < size; i++) {
                Node cur = queue.remove();

                if (pre != null) {
                    pre.next = cur;
                }
                pre = cur;

                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            // last node
            pre.next = null;
        }

        return root;
    }

    public Node connect2(Node root) {
        // 此处将优化额外空间的使用
        if (root == null) {
            return null;
        }

        Node start = root;
        while (start != null) {
            last = null; // 用来迭代更新每一个节点
            nextStart = null; // 每一层的第一个node

            for (Node p = start; p != null; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }
            start = nextStart;
        }
        return root;
    }

    public void handle(Node p) {
        if (last != null) {
            last.next = p;
        }
        if (nextStart == null) {
            nextStart = p;
        }
        last = p;
    }
}
