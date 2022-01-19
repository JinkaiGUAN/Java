import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Peter
 * @date: 19/01/2022
 * @description: https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 */
public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            Integer max = Integer.MIN_VALUE;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();

                if (node.val > max) {
                    max = node.val;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            res.add(max);
        }

        return res;
    }
}
