package main.com.peter.java.median;

import main.com.peter.java.entity.TreeNode;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ54KthNode
 * Author:   Peter
 * Date:     30/04/2022 17:07
 * Description: https://www.nowcoder.com/practice/57aa0bab91884a10b5136ca2c087f8ff?tpId=265&tags=&title=&difficulty=0
 * &judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13
 * History:
 * Version:
 */
public class JZ54KthNode {
    private TreeNode res = null;
    private int count = 0;

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * Preorder of BSt is a ordered array. Thus we only need to find the k-th node using pre-order method,
     * then we can produce it.
     *
     * @param proot TreeNode类
     * @param k int整型
     * @return int整型
     */
    public int KthNode (TreeNode proot, int k) {
        // write code here
        preOrder(proot, k);
        return res == null ? -1 : res.val;
    }

    public void preOrder (TreeNode root, int k) {
        if (root == null || count > k) {
            return;
        }

        // left
        preOrder(root.left, k);
        // root
        count++;
        if (count == k) {
            res = root;
        }
        // right
        preOrder(root.right, k);
    }
}
