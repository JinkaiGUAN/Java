/**
 * Copyright (C), Peter GUAN
 * FileName: MaximumDepthOfNaryTree
 * Author:   Peter
 * Date:     22/01/2022 11:17
 * Description: https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 * History:
 * Version:
 */
public class MaximumDepthOfNaryTree {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        if (root.children != null) {
            for (Node n : root.children) {
                depth = Math.max(depth, maxDepth(n));
            }
        }

        return depth + 1;
    }
}
