/**
 * Copyright (C), Peter GUAN
 * FileName: TrimABinarySearcgTree
 * Author:   Peter
 * Date:     06/02/2022 09:44
 * Description: https://leetcode-cn.com/problems/trim-a-binary-search-tree/
 * History:
 * Version:
 */
public class TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }

    public TreeNode trimBSTIteration(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        // 处理头节点， 让它移动到合适位置
        while (root != null && (root.val < low || root.val > high)) {
            if (root.val < low) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        // 处理root左子树
        TreeNode cur = root;
        while (cur != null) {
            while (cur.left != null && cur.left.val < low) {
                cur.left = cur.left.right;
            }
            cur = cur.left;
        }

        // 处理root右子树
        cur = root;
        while (cur != null) {
            while (cur.right != null && cur.right.val > high) {
                cur.right = cur.right.left;
            }
            cur = cur.right;
        }

        return root;
    }
}
