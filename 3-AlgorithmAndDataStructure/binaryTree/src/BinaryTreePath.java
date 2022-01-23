import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Copyright (C), Peter GUAN
 * FileName: BinaryTreePath
 * Author:   Peter
 * Date:     23/01/2022 11:55
 * Description:
 * History:
 * Version:
 */
public class BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        List<Integer> paths = new ArrayList<>();

        if (root == null) {
            return res;
        }

        traversal(root, paths, res);
        return res;
    }

    public void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        paths.add(root.val);

        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            res.add(sb.toString());
            return;
        }
        if (root.left != null) {
            traversal(root.left, paths, res);
            paths.remove(paths.size() - 1);
        }
        if (root.right != null) {
            traversal(root.right, paths, res);
            paths.remove(paths.size() - 1);
        }
    }
}
