import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Peter
 * @date: 18/01/2022
 * @description: https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */
public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            Double sum = 0.0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                sum += node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(sum / size);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(3.0 / 2);
    }
}
