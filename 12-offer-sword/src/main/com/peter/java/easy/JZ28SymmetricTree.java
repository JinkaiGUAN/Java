package main.com.peter.java.easy;

import main.com.peter.java.entity.TreeNode;

import java.util.Stack;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ28SymmetricTree
 * Author:   Peter
 * Date:     21/04/2022 23:20
 * Description: https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=265&tags=&title=&difficulty=0
 * &judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 */
public class JZ28SymmetricTree {
    boolean isSymmetricalIteration(TreeNode pRoot) {
        // In this part, we are going to use stack to help us gain the node
        if (pRoot == null || (pRoot.left == null && pRoot.right == null)) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        if (pRoot.left != null && pRoot.right != null) {
            stack.push(pRoot.left);
            stack.push(pRoot.right);
        } else {
            return false;
        }

        while (!stack.isEmpty()) {
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();

            if (node1.val != node2.val) {
                return false;
            }

            // add nodes
            if (node1.left != null && node2.right != null) {
                stack.push(node1.left);
                stack.push(node2.right);
            } else if ((node1.left == null && node2.right != null) || (node1.left != null && node2.right == null)) {
                return false;
            }
            if (node1.right != null && node2.left != null) {
                stack.push(node1.right);
                stack.push(node2.left);
            } else if ((node1.right == null && node2.left != null) || (node1.right != null && node2.left == null)) {
                return false;
            }
        }

        return true;
    }

    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetricalRecursion(pRoot);
    }

    boolean isSymmetricalRecursion(TreeNode pRoot) {

        return pRoot == null || isSymmetricalRecursionHelper(pRoot.left, pRoot.right);
    }

    boolean isSymmetricalRecursionHelper(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            // both  nodes are null
            return true;
        }
        if (node1 == null || node2 == null) {
            // If one of the node is null
            return false;
        }

        return node1.val == node2.val && isSymmetricalRecursionHelper(node1.left, node2.right) && isSymmetricalRecursionHelper(node1.right, node2.left);
    }
}
