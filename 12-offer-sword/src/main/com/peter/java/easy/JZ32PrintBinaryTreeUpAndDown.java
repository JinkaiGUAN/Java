package main.com.peter.java.easy;

import main.com.peter.java.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ32PrintBinaryTreeUpAndDown
 * Author:   Peter
 * Date:     23/04/2022 15:20
 * Description: https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701?tpId=265&tags=&title=&difficulty=0
 * &judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 */
public class JZ32PrintBinaryTreeUpAndDown {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> res = new ArrayList<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            res.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return res;
    }
}
