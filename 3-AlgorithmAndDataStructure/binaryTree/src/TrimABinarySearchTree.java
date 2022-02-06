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
}
