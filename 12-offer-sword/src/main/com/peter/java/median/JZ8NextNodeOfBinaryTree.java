package main.com.peter.java.median;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ8NextNodeOfBinaryTree
 * Author:   Peter
 * Date:     11/04/2022 21:50
 * Description: https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=265&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 *
 * @author: Peter
 */
public class JZ8NextNodeOfBinaryTree {

    /**
     * Given a treeNode of a binary tree, return the next node in inorder traversal.
     *
     * If the node has right child,then the next node should be the leftest node in its right child tree.
     * If the node does not have right child:
     *  1. If the node is its parent left node, then return its parent node.
     *  2. Else, try to find a parent node that its left node is the current node, then return the left node of this
     *  parent node.
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // node is null
        if (pNode == null) {
            return null;
        }

        // node has right child
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        // node does not have right child
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }

        return null;
    }
}

class TreeLinkNode {

    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    public TreeLinkNode(int val) {
        this.val = val;
    }
}