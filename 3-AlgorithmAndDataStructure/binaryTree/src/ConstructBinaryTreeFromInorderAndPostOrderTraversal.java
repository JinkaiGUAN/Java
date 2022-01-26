/**
 * Copyright (C), Peter GUAN
 * FileName: ConstructBinaryTreeFromInorderAndPostOrderTraversal
 * Author:   Peter
 * Date:     25/01/2022 10:07
 * Description: https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * History:
 * Version:
 */
public class ConstructBinaryTreeFromInorderAndPostOrderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return getChild(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }


    public TreeNode getChild(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        // 中断条件
        if (inRight - inLeft < 1) {
            // 此条件必要， 因为可能会出现子树只有一颗
            return null;
        }
        if (inRight - inLeft == 1) {
            return new TreeNode(inorder[inLeft]);
        }

        // 执行体
        int rootVal = postorder[postRight - 1];
        TreeNode root = new TreeNode(rootVal);

        int inIdx = 0;
        for (int i = inLeft ; i < inRight; i++) {
            if (inorder[i] == rootVal) {
                inIdx = i;
                break;
            }
        }

        TreeNode leftChild = getChild(inorder, inLeft, inIdx, postorder, postLeft, postLeft + (inIdx - inLeft));
        TreeNode rightChild = getChild(inorder, inIdx + 1, inRight, postorder, postLeft + (inIdx - inLeft),
                postRight -1);
        root.left = leftChild;
        root.right = rightChild;

        return root;
    }
}
