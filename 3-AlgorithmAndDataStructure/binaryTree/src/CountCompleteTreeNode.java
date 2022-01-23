import java.util.Queue;
import java.util.LinkedList;

/**
 * Copyright (C), Peter GUAN
 * FileName: CountCompleteTreeNode
 * Author:   Peter
 * Date:     23/01/2022 10:26
 * Description:
 * History:
 * Version:
 */
public class CountCompleteTreeNode {
    public int countNodes(TreeNode root) {
        // 使用层次遍历， 每取出一个节点， 即访问一个节点 就记录一次

        Queue<TreeNode> queue = new LinkedList<>();
        int nodeCount = 0;

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

            nodeCount++;
        }

        return nodeCount;
    }

    public int countNodeRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftNum = countNodeRecursion(root.left);
        int rightNum = countNodeRecursion(root.right);

        return leftNum + rightNum + 1;
    }
}
