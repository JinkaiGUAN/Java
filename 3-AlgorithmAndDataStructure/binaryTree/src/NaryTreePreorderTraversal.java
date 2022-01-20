import java.util.List;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Collections;

/**
 * @author: Peter
 * @date: 20/01/2022
 * @description: https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 */
public class NaryTreePreorderTraversal {
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

    public List<Integer> preorder(Node root) {
        // 在此迭代方法中， 我们在取出该元素之后 回继续放回去 并且还要放一个null 节点来标记我们是否访问过该节点
        List<Integer> res = new LinkedList<>();
        Stack<Node> stack = new Stack<>();

        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            Node node = stack.pop();

            if (node != null) {
                // if the node is not null, representing that the
                if (node.children == null || node.children.size() == 0) {
                    // 该节点为叶子节点
                    continue;
                }
                Collections.reverse(node.children);
                for(Node n : node.children) {
                    if (n != null) {
                        stack.push(n);
                    }
                }

                stack.push(node);
                stack.push(null);
            } else {
                // if the node is null, meaning that we have to add its previous node into the res list.
                node = stack.pop();
                res.add(node.val);
            }
        }

        return res;
    }

}
