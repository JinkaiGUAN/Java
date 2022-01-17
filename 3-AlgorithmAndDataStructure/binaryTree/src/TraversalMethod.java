import java.util.ArrayList;

/**
 * @author: Peter
 * @date: 17/01/2022
 * @description:
 */
public class TraversalMethod {

    // Traversal methods, these are based on DFS
    public void preorderTraversal(TreeNode cur, ArrayList<Integer> res) {
        if (cur == null) {
            return;
        }
        res.add(cur.val);
        preorderTraversal(cur.left, res);
        preorderTraversal(cur.right, res);
    }

    public void inorderTraversal(TreeNode cur, ArrayList<Integer> res) {
        if (cur == null) {
            return;
        }
        inorderTraversal(cur.left, res);
        res.add(cur.val);
        inorderTraversal(cur.right, res);
    }

    public void postorderTraversal(TreeNode cur, ArrayList<Integer> res) {
        if (cur == null) {
            return;
        }
        postorderTraversal(cur.left, res);
        postorderTraversal(cur.right, res);
        res.add(cur.val);
    }

    public static void main(String[] args) {

        // construct a tree
        TreeNode head = new TreeNode(5);
        TreeNode leftChild = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        TreeNode rightChild = new TreeNode(6, new TreeNode(7), new TreeNode(8));

        // assign the child for the head;
        head.left = leftChild;
        head.right = rightChild;

        ArrayList<Integer> res = new ArrayList<>();

        TraversalMethod solution = new TraversalMethod();
        solution.preorderTraversal(head, res);
        System.out.println(res);

    }


}
