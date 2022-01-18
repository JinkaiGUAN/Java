import java.util.List;

/**
 * @author: Peter
 * @date: 18/01/2022
 * @description:
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int val) {
        this.val = val;
        this.children = null;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
