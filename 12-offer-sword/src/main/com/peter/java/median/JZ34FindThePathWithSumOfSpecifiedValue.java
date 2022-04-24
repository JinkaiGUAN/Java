package main.com.peter.java.median;

import main.com.peter.java.entity.TreeNode;

import java.util.ArrayList;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ34FindThePathWithSumOfSpecifiedValue
 * Author:   Peter
 * Date:     24/04/2022 20:15
 * Description: https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=265&tqId=39236&rp=1&ru=/exam
 * /oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13&difficulty=undefined&judgeStatus=undefined&tags
 * =&title=
 * History:
 * Version:
 */
public class JZ34FindThePathWithSumOfSpecifiedValue {

    private ArrayList<ArrayList<Integer>> res;
    private ArrayList<Integer> path;


    /**
     * Recursion + back tracking
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {

        // initial variables
        res = new ArrayList<ArrayList<Integer>>();
        path = new ArrayList<Integer>();

        if (root == null) {
            return res;
        }

        FindPathRecursion(root, expectNumber);

        return res;
    }

    private void FindPathRecursion(TreeNode root, int target) {
        // back condition
        if (target - root.val == 0 && root.left == null && root.right == null) {
            path.add(root.val);
            res.add(new ArrayList<Integer>(path));
            path.remove(path.size() - 1);
            return;
        }

        // recursion
        path.add(root.val);
        if (root.left != null) {
            FindPathRecursion(root.left, target - root.val);
        }
        if (root.right != null) {
            FindPathRecursion(root.right, target - root.val);
        }
        path.remove(path.size() - 1);
    }
}
