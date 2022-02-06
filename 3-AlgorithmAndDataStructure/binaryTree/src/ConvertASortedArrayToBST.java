import java.util.LinkedList;
import java.util.Queue;

/**
 * Copyright (C), Peter GUAN
 * FileName: ConvertAsortedArrayToBST
 * Author:   Peter
 * Date:     06/02/2022 10:24
 * Description: https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * History:
 * Version:
 */
public class ConvertASortedArrayToBST {
    public TreeNode sortedArraysToBST(int[] nums) {
        return inorderTraversalBuilding(nums, 0, nums.length - 1);
    }

    public TreeNode inorderTraversalBuilding(int[] nums, int left, int right) {
        // 此次我们实行[left, right]区间， 双侧都闭合
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = inorderTraversalBuilding(nums, left, mid - 1);
        root.right = inorderTraversalBuilding(nums, mid + 1, right);

        return root;
    }

    public TreeNode sortedArraysToBSTUsingIteration(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(-1);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> leftIndexes = new LinkedList<>();
        Queue<Integer> rightIndexes = new LinkedList<>();

        nodeQueue.offer(root);
        leftIndexes.offer(0);
        rightIndexes.offer(nums.length - 1);

        while (!nodeQueue.isEmpty()) {
            TreeNode curNode = nodeQueue.poll();
            int left = leftIndexes.poll();
            int right = rightIndexes.poll();
            int mid = left + (right - left) / 2;

            curNode.val = nums[mid];

            // 左子树
            if (left <= mid - 1) {
                curNode.left = new TreeNode(-1);
                nodeQueue.offer(curNode.left);
                leftIndexes.offer(left);
                rightIndexes.offer(mid - 1);
            }

            // 右子树
            if (right >= mid + 1) {
                curNode.right = new TreeNode(-1);
                nodeQueue.offer(curNode.right);
                leftIndexes.offer(mid + 1);
                rightIndexes.offer(right);
            }
        }

        return root;
    }
}
