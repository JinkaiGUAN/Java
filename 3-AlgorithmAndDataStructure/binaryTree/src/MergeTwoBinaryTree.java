/**
 * Copyright (C), Peter GUAN
 * FileName: MergeTwoBinaryTree
 * Author:   Peter
 * Date:     27/01/2022 10:16
 * Description: https://leetcode-cn.com/problems/merge-two-binary-trees/
 * History:
 * Version:
 */
public class MergeTwoBinaryTree {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        root1.val = root1.val + root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }


}
