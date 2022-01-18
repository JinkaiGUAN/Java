import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;

/**
 * @author: Peter
 * @date: 18/01/2022
 * @description: https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
public class LevelOrderTraversal2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            List<Integer> innerList = new LinkedList<>();
            int size = queue.size();

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
        Collections.reverse(res);

        return res;
    }
}
