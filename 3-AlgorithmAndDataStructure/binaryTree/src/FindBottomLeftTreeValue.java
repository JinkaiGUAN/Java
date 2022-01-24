import java.util.Queue;
import java.util.LinkedList;

/**
 * Copyright (C), Peter GUAN
 * FileName: FindBottonLeftTreeValue
 * Author:   Peter
 * Date:     24/01/2022 11:46
 * Description: https://leetcode-cn.com/problems/find-bottom-left-tree-value/
 * History:
 * Version:
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int res = 0;

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (i == 0) {
                    res = node.val;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return res;
    }
}
