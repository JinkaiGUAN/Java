/**
 * Copyright (C), Peter GUAN
 * FileName: ConvertBSTTOGreaterTree
 * Author:   Peter
 * Date:     06/02/2022 10:51
 * Description: https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * History:
 * Version:
 */
public class ConvertBSTTOGreaterTree {

    int sum;
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        inversePostOrderTraversal(root);
        return root;
    }

    public void inversePostOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        // right -> middle -> left
        inversePostOrderTraversal(root.right);;
        sum += root.val;
        root.val = sum;
        inversePostOrderTraversal(root.left);
    }
}
