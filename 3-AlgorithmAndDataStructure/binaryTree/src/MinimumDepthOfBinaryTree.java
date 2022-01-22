import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Peter
 * @date: 20/01/2022
 * @description: https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left == null && node.right == null) {
                    return depth;
                }
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

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = minDepth2(root.left);
        int rightDepth = minDepth2(root.right);
        if (root.left == null) {
            return leftDepth + 1;
        }
        if (root.right == null) {
            return rightDepth + 1;
        }

        return Math.min(leftDepth, rightDepth) + 1;
    }
}
