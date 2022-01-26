/**
 * Copyright (C), Peter GUAN
 * FileName: MaximumBinaryTree
 * Author:   Peter
 * Date:     26/01/2022 12:00
 * Description: https://leetcode-cn.com/problems/maximum-binary-tree/
 * History:
 * Version:
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return getChild(nums, 0, nums.length);
    }

    public TreeNode getChild(int[] nums, int left, int right) {
        // 中断条件, 左闭右开
        if (right - left < 1) {
            // no element
            return null;
        }
        if (right - left == 1) {
            return new TreeNode(nums[left]);
        }

        // 构造树 preorder tranversal
        int maxIdx = left;
        int maxVal = nums[maxIdx];

        for (int i = left; i < right; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIdx = i;
            }
        }

        TreeNode root = new TreeNode(maxVal);
        root.left = getChild(nums, left, maxIdx);
        root.right = getChild(nums, maxIdx + 1, right);

        return root;
    }

}
