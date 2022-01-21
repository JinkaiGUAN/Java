/**
 * Copyright (C), Peter GUAN
 * FileName: SymmetricTree
 * Author:   Peter
 * Date:     21/01/2022 09:15
 * Description:
 * History:
 * Version:
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        // 此处的left right 并非左右子树， 而是相互对应需要比较的节点

        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
//        if (left.val == right.val){
//            return true;
//        }
        if (left.val != right.val) {
            return false;
        }

        boolean compareOutside = compare(left.left, right.right);
        boolean compareInside = compare(left.right, right.left);

        return compareInside && compareOutside;
    }
}
