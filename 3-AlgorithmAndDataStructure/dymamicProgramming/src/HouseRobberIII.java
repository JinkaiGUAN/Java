/**
 * Copyright (C), Peter GUAN
 * FileName: HouseRobberIII
 * Author:   Peter
 * Date:     14/03/2022 22:32
 * Description: https://leetcode-cn.com/problems/house-robber-iii/
 * History:
 * Version:
 */
public class HouseRobberIII {

    public int rob(TreeNode root) {
        int[] res = robAction(root);

        return Math.max(res[0], res[1]);
    }

    public int[] robAction(TreeNode root) {
        // dp[0] 表示不偷该节点， dp[1]表示偷该节点
        int[] res = new int[2];

        if (root == null) {
            return res;
        }

        int[] left = robAction(root.left);
        int[] right = robAction(root.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}