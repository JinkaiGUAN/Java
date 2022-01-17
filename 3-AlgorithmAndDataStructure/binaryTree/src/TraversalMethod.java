import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

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

    public List<Integer> preorderTraversalIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }

        return res;
    }

    public void inorderTraversal(TreeNode cur, ArrayList<Integer> res) {
        if (cur == null) {
            return;
        }
        inorderTraversal(cur.left, res);
        res.add(cur.val);
        inorderTraversal(cur.right, res);
    }

    public List<Integer> inorderTraversalIteration(TreeNode root) {
        // 入栈顺序： 左 - 右
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }

        return res;
    }

    public void postorderTraversal(TreeNode cur, ArrayList<Integer> res) {
        if (cur == null) {
            return;
        }
        postorderTraversal(cur.left, res);
        postorderTraversal(cur.right, res);
        res.add(cur.val);
    }

    public List<Integer> postorderTraversalIteration(TreeNode root) {
        // 先序遍历（中左右） -> 中右左 -> 左右中
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(res);

        return res;
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
