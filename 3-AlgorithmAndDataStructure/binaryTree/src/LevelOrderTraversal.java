import java.util.List;
import java.util.LinkedList;
import java.util.Queue;


/**
 * @author: Peter
 * @date: 18/01/2022
 * @description: https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            List<Integer> innerList = new LinkedList<>();
            int size = queue.size();

            // add elements of the same level to a list
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                innerList.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            res.add(innerList);
        }

        return res;
    }
}
