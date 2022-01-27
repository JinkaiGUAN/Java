/**
 * Copyright (C), Peter GUAN
 * FileName: SearchInABinarySearchTree
 * Author:   Peter
 * Date:     27/01/2022 10:43
 * Description: https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 * History:
 * Version:
 */
public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}
