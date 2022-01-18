import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Peter
 * @date: 18/01/2022
 * @description: https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 */
public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>>  levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                level.add(node.val);

//                queue.addAll(node.children);
                if (node.children == null || node.children.size() == 0) {
                    continue;
                }
                for (Node child : node.children) {
                    if (child != null) {
                        queue.add(child);
                    }
                }
            }
            res.add(level);
        }

        return res;
    }
}
