import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/**
 * @author: Peter
 * @date: 20/01/2022
 * @description: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode  root) {
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();

        if  (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            depth++;
        }

        return depth;
    }
}
