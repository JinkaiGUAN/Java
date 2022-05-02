package main.com.peter.java.easy;

import main.com.peter.java.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ55TreeDepthOfBinaryTree
 * Author:   Peter
 * Date:     01/05/2022 21:31
 * Description: https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b?tpId=265&tqId=39252&rp=1&ru=/exam
 * /oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D2%26tpId%3D13%26type%3D265&difficulty=undefined
 * &judgeStatus=undefined&tags=&title=
 * History:
 * Version:
 */
public class JZ55TreeDepthOfBinaryTree {
    public int TreeDepth(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int res = 0;

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res += 1;

        }

        return res;
    }

    public int TreeDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(TreeDepth2(root.left), TreeDepth2(root.right)) + 1;
    }
}
