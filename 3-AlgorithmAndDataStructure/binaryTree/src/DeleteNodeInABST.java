/**
 * Copyright (C), Peter GUAN
 * FileName: DeleteNodeInABST
 * Author:   Peter
 * Date:     05/02/2022 10:27
 * Description: https://leetcode-cn.com/problems/delete-node-in-a-bst/
 * History:
 * Version:
 */
public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }

    private TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key > root.val) {
            root.right = delete(root.right, key);
        } else if (key < root.val) {
            root.left = delete(root.left, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // 左右子树都在
            TreeNode cur = root.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            cur.left = root.left;
            root = root.right;
        }
        return root;
    }
}
