
/**
 * Copyright (C), Peter GUAN
 * FileName: SubtreeOfAnotherTree
 * Author:   Peter
 * Date:     22/01/2022 10:46
 * Description:
 * History:
 * Version:
 */
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
       return dfs(root, subRoot);
    }

    public boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        return dfs(root.left, subRoot) || dfs(root.right, subRoot) || check(root, subRoot);
    }

    public boolean check(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }

        return check(root.left, subRoot.left) && check(root.right, subRoot.right);
    }
}
