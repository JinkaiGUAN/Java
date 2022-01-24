import com.sun.source.tree.Tree;

/**
 * Copyright (C), Peter GUAN
 * FileName: SumOfLeftLeaves
 * Author:   Peter
 * Date:     24/01/2022 11:36
 * Description: https://leetcode-cn.com/problems/sum-of-left-leaves/
 * History:
 * Version:
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftValue = sumOfLeftLeaves(root.left);  // 左
        int rightVale = sumOfLeftLeaves(root.right); // 右

        int midVal = 0; // 中
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midVal = root.left.val;
        }

        return midVal + leftValue + rightVale;
    }

}
