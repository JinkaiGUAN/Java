/**
 * Copyright (C), Peter GUAN
 * FileName: InsertIntoABinaryTree
 * Author:   Peter
 * Date:     05/02/2022 10:03
 * Description: https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 * History:
 * Version:
 */
public class InsertIntoABinaryTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}
