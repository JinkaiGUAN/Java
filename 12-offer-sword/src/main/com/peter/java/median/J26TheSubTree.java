package main.com.peter.java.median;

import main.com.peter.java.entity.TreeNode;

/**
 * Copyright (C), Peter GUAN
 * FileName: J26TheSubTree
 * Author:   Peter
 * Date:     20/04/2022 09:04
 * Description: https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=265&tags=&title=&difficulty=0
 * &judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D265
 * History:
 * Version:
 */
public class J26TheSubTree {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        // one of them is null or both are null
        if (root1 == null || root2 == null) {
            return false;
        }

        return isTheSame(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean isTheSame(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        } else if (root1 == null) {
            return false;
        }

        return root1.val == root2.val && isTheSame(root1.left, root2.left) && isTheSame(root1.right, root2.right);
    }

}
