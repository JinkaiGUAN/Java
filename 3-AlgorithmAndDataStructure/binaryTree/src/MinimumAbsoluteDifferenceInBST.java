/**
 * Copyright (C), Peter GUAN
 * FileName: MinimumAbsoluteDifferenceInBST
 * Author:   Peter
 * Date:     28/01/2022 09:49
 * Description: https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 * History:
 * Version:
 */
public class MinimumAbsoluteDifferenceInBST {
    TreeNode pre; // previous node
    int res = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        inorderTraversal(root);
        return res;
    }

    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);

        if (pre != null) {
            res = Math.min(res, root.val - pre.val);
        }
        pre = root;

        inorderTraversal(root.right);
    }

}
