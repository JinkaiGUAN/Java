package main.com.peter.java.median;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ7RebuildBinaryTree
 * Author:   Peter
 * Date:     10/04/2022 22:57
 * Description: https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=265&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 *
 * @author: Peter
 */

public class JZ7RebuildBinaryTree {

    /**
     * According preorder traversal and inorder traversal to reconstruct the binary tree.
     *
     * We know that preorder has the order of [root, left, right], and inorder has the order of [left, root, right].
     * We can use get the root in preorder first, then split the inorder part in inorder one. We can construct left and
     * right tree recursively.
     *
     * root = TreeNode(root);
     *
     * find the index of root in inorder section, ana retrieve the left and right parts in preorder section.
     * root.left = functionName(leftPart);
     * root.right = functionName(rightPart);
     * @param pre
     * @param vin
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        return constructBinaryTree(pre, 0, pre.length - 1, vin, 0, vin.length - 1);
    }

    /**
     * For the index, we define that it should be the exeact indices for right and left part,
     * i.e.e, [right, left] are all included.
     */
    private TreeNode constructBinaryTree(int[] preorder, int preLeft, int preRight,
                                         int[] inorder, int inLeft, int inRight) {
        // return condition
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }


        // Get the root value and find its indices inorder section
        int rootVal = preorder[preLeft];
        int rootIdx = inLeft;
        for (int i = inLeft; i <= inRight; i++) {
            if (rootVal == inorder[i]) {
                rootIdx = i;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        // left part length in preorder: rootIdx - 1 - inLeft + 1
        int leftLength = rootIdx - 1 - inLeft + 1;
        root.left = constructBinaryTree(preorder, preLeft + 1, preLeft + leftLength,
                inorder, inLeft, rootIdx - 1);
        root.right = constructBinaryTree(preorder, preLeft + leftLength + 1, preRight,
                inorder, rootIdx + 1, inRight);

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
