import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: Peter
 * @date: 20/01/2022
 * @description: https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 */
public class NaryTreePostorderTraversal {
    public class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int val) {
            this.val = val;
            this.children = null;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public List<Integer> postorder(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> res = new LinkedList<>();

        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            Node node = stack.pop();

            if (node != null) {
                stack.push(node);
                stack.push(null);

                if (node.children == null || node.children.size() == 0){
                    continue;
                }
                Collections.reverse(node.children);
                for (Node n : node.children) {
                    if (n != null) {
                        stack.push(n);
                    }
                }
            } else {
                node = stack.pop();
                res.add(node.val);
            }

        }

        return res;

    }

}
