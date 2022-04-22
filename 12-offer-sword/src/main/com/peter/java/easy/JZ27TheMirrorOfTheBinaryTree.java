package main.com.peter.java.easy;

import main.com.peter.java.entity.TreeNode;

/**
 * Copyright (C), Peter GUAN
 * FileName: JZ27TheMirrorOfTheBinaryTree
 * Author:   Peter
 * Date:     21/04/2022 22:09
 * Description: https://www.nowcoder.com/practice/a9d0ecbacef9410ca97463e4a5c83be7?tpId=265&tqId=39229&rp=1&ru=/exam
 * /oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D13&difficulty=undefined&judgeStatus=undefined&tags
 * =&title=
 * History:
 * Version:
 */
public class JZ27TheMirrorOfTheBinaryTree {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pRoot TreeNode类
     * @return TreeNode类
     */
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if (pRoot == null) {
            return pRoot;
        }

        TreeNode cur = pRoot.left;

        pRoot.left = Mirror(pRoot.right);
        pRoot.right = Mirror(cur);

        return pRoot;
    }
}
