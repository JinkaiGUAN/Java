/**
 * Copyright (C), Peter GUAN
 * FileName: ConstructBinaryTreeFromPreorderAndInorderTraversal
 * Author:   Peter
 * Date:     26/01/2022 11:08
 * Description: https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * History:
 * Version:
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 使用preorder序列放inorder序列分解为两部分， 之后将preorder序列也分解
        return getChild(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode getChild(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        // 所有边界值都是左闭右开
        // 终止条件
        if (inRight - inLeft == 1) {
            // 只有一个节点
            return new TreeNode(inorder[inLeft]);
        }
        if (inRight - inLeft < 1) {
            // 没有节点
            return null;
        }

        // 执行体
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);

        // find the index to split the left and right part in the inorder list
        int inIdx = inLeft;
        for (int i = inLeft; i < inRight; i++) {
            if (rootVal == inorder[i]) {
                inIdx = i;
                break;
            }
        }

        root.left = getChild(preorder, preLeft + 1, preLeft  + 1 + (inIdx - inLeft), inorder, inLeft, inIdx);
        root.right = getChild(preorder, preLeft + 1 + (inIdx - inLeft), preRight, inorder, inIdx + 1, inRight);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};

        ConstructBinaryTreeFromPreorderAndInorderTraversal solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        solution.buildTree(preorder, inorder);
    }
}
