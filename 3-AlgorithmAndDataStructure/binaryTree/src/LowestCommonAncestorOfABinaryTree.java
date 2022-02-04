/**
 * Copyright (C), Peter GUAN
 * FileName: LowestCommonAncestorOfABinaryTree
 * Author:   Peter
 * Date:     29/01/2022 10:32
 * Description: https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * History:
 * Version:
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else if (left == null && right == null) {
            return null;
        } else {
            return root;
        }
    }
}
