package main.com.peter.java.median;

import main.com.peter.java.entity.TreeNode;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ36ConvertBSTTODoublyLinkedList
 * Author:   Peter
 * Date:     24/04/2022 20:46
 * Description: https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=265&tags=&title=&difficulty=0
 * &judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 */
public class JZ36ConvertBSTTODoublyLinkedList {
    /**
     * To handle the leaf node problem.
     */
    private TreeNode pre;

    /**
     * record the head node;
     */
    private TreeNode head;

    /**
     * Inorder traversal of BST would be an ordered one.
     */
    public TreeNode Convert(TreeNode root) {
        if (root == null) {
            return null;
        }

        Convert(root.left);

        if (pre == null) {
            head = root;
            pre = root;
        } else {
            pre.right = root;
            root.left = pre;
            pre = root;
        }

        Convert(root.right);

        return head;
    }

}
