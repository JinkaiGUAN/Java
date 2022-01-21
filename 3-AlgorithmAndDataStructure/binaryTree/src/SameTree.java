import java.util.LinkedList;
import java.util.Queue;

/**
 * Copyright (C), Peter GUAN
 * FileName: SameTree
 * Author:   Peter
 * Date:     21/01/2022 09:54
 * Description:
 * History:
 * Version:
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();

        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        queueP.add(p);
        queueQ.add(q);

        while (!queueP.isEmpty() && !queueQ.isEmpty()) {
            TreeNode pNode = queueP.remove();
            TreeNode qNode = queueQ.remove();

            if (pNode.val != qNode.val) {
                return false;
            }

            TreeNode leftQ = qNode.left, rightQ = qNode.right, leftP = pNode.left, rightP = pNode.right;

            if (leftQ == null ^ leftP == null) {
                // one of them is null
                return false;
            }
            if (rightP == null ^ rightQ == null) {
                return false;
            }

            if (leftQ != null) {
                queueQ.add(leftQ);
            }
            if (rightQ != null) {
                queueQ.add(rightQ);
            }
            if (leftP != null) {
                queueP.add(leftP);
            }
            if (rightP != null) {
                queueP.add(rightP);
            }

        }

        return queueP.isEmpty() && queueQ.isEmpty();
    }

}
