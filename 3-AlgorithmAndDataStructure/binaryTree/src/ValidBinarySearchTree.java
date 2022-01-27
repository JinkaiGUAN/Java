/**
 * Copyright (C), Peter GUAN
 * FileName: ValidBinarySearchTree
 * Author:   Peter
 * Date:     27/01/2022 10:52
 * Description: https://leetcode-cn.com/problems/validate-binary-search-tree/
 * History:
 * Version:
 */
public class ValidBinarySearchTree {
    TreeNode max;

    public boolean isValidBST(TreeNode root) {
        // 中序遍历递归， 是否是左做完， 判断中间节点的时候不需要考虑左节点？
        if (root == null) {
            return true;
        }

        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }

        if (max != null && root.val <= max.val) {
            return false;
        }
        max = root;

        boolean right = isValidBST(root.right);
        return right;
    }
}
