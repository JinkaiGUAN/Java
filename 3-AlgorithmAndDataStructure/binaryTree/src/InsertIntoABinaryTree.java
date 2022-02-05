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

    public TreeNode insertIntoBSTIteration(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode newRoot = root;
        TreeNode pre = root;
        while (root != null) {
            pre = root;
            if (root.val > val) {
                root = root.left;
            } else if (root.val < val) {
                root = root.right;
            }
        }

        if (pre.val > val) {
            pre.left = new TreeNode(val);
        } else {
            pre.right = new TreeNode(val);
        }

        return newRoot;
    }
}
