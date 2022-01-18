import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: Peter
 * @date: 18/01/2022
 * @description:
 */
public class IterativeTraversalMethod {
    // 迭代方法的统一写法， 即在stack中存入null用来标记null前的元素被访问过

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>(); // Linkedlist 在增加元素时较快
        Stack<TreeNode> stack = new Stack<>();

        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            if (node != null) {
                stack.pop(); // 将该节点弹出， 避免重复操作， 下面再将右中左节点添加到栈中

                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.right);
                }
                stack.push(node); // 添加中节点
                stack.push(null); // 中节点访问过， 加入空姐点作为标记
            } else {
                // 只有遇到空姐点的时候， 才将下一个节点放进结果集中
                stack.pop();  // 弹出空姐点
                node = stack.peek();
                stack.pop();
                res.add(node.val);
            }
        }

        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            stack.pop();
            if (node != null) {

                if (node.right != null) {
                    stack.push(node.right);
                }
                stack.push(node);
                stack.push(null);

                if (node.left != null) {
                    stack.push(node.left);
                }
            } else {
                node = stack.peek();
                stack.pop();
                res.add(node.val);
            }
        }

        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node != null) {
                stack.push(node);
                stack.push(null);

                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            } else {
                node = stack.pop();
                res.add(node.val);
            }
        }

        return res;
    }

}
