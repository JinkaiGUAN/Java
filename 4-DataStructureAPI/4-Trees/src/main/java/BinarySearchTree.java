package main.java;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Copyright (C), Peter GUAN
 * FileName: BinarySearchTree
 * Author:   Peter
 * Date:     05/02/2022 09:40
 * Description: In this binary searching tree, we have key and value. Key will be used to sort the tree, and value
 * will be used as the output when we use traversal methods.
 * History:
 * Version:
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private Node<Key, Value> root;
    private int N;

    public BinarySearchTree() {
        this.root = null;
        this.N = 0;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node<Key, Value> put(Node<Key, Value> root, Key key, Value val) {
        //给指定树x上，添加键一个键值对，并返回添加后的新树，
        if (root == null) {
            N++;
            return new Node<Key, Value>(key, val, null, null);
        }

        int cmp = key.compareTo(root.key);
        if (cmp > 0) {
            root.right = put(root.right, key, val);
        } else if (cmp < 0) {
            root.left = put(root.left, key, val);
        } else {
            root.val = val;
        }

        N++;
        return root;
    }

    public Value get(Key key) {
        // Ge the value of the key specified.
        Node<Key, Value> node = getNode(key);

        if (node != null) {
            return node.val;
        } else {
            return null;
        }
    }

    private Node<Key, Value> getNode(Key key) {
        // Return a node for the certain key.
        Node<Key, Value> cur = root;
        while (cur != null) {
            int cmp = cur.key.compareTo(key);
            if (cmp > 0) {
                // go to the right
                cur = cur.right;
            } else if (cmp < 0) {
                // go to the left
                cur = cur.left;
            } else {
                // find the value
                return cur;
            }
        }

        return null;
    }

    public void delete(Key key) {
        // Delete the node with the key specified. However, we must consider the tree structure after deleting the
        // corresponding node.

        Node<Key, Value> node = delete(root, key);

    }

    /**
     * Delete the node with key specified and return the new tree.
     *
     * @param root The node where we are going to delete the node.
     * @param key The key helps us position which node should be deleted.
     * @return
     */
    private Node<Key, Value> delete(Node<Key, Value> root, Key key) {
        //删除指定树x上的键为key的键值对，并返回删除后的新树
        if (root == null) {
            return null;
        }

        int cmp = key.compareTo(root.key);
        if (cmp > 0) {
            // go to the right tree
            root.right = delete(root.right, key);
        } else if (cmp < 0) {
            // go to the left tree
            root.left = delete(root.left, key);
        } else {
            // find the node
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // The node has both left and right node
            // find the minimal node for the subtree.
            Node<Key, Value> minNode = root.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }

            // Delete the minimal node in the right subtree
            Node<Key, Value> deleteNode = root.right;
            while (deleteNode.left != null) {
                if (deleteNode.left.left == null) {
                    deleteNode.left = null;
                }
                deleteNode = deleteNode.left;
            }

            // Let the minNode be the new root, and the original left and right subtree kept the original structure.
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;

            N--;
        }

        return root;
    }

    public Key min() {
        return min(root).key;
    }

    private Node<Key, Value> min(Node<Key, Value> root) {
        if (root.left != null) {
            return min(root.left);
        } else {
            return root;
        }
    }

    public Key max() {
        return max(root).key;
    }

    private Node<Key, Value> max(Node<Key, Value> root) {
        if (root.right != null) {
            return max(root.right);
        } else {
            return root;
        }
    }

    public int size() {
        return N;
    }

    // The following parts are traversal method achievements, where recursion and iteration ideas are being used. In
    // this part, we are going to output the keys.
    public Queue<Key> preorderTraversal(boolean isIteration) {
        if (isIteration) {
            return preorderTraversalIterative();
        } else {
            // do the recursion preorder traversal
            Queue<Key> keys = new LinkedList<>();
            preorderTraversalRecursion(root, keys);
            return keys;
        }
    }

    private Queue<Key> preorderTraversalIterative() {
        Queue<Key> res = new LinkedList<>();
        Stack<Node<Key, Value>> stack = new Stack<>();

        // In this iterative method, we are going to add null to identify whether we add this node into our res queue
        // or not.
        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            Node<Key, Value> node = stack.pop();

            if (node != null) {
                // Now we have not visited this node

                // right
                if (node.right != null) {
                    stack.push(root.right);
                }
                // left
                if (node.left != null) {
                    stack.push(root.left);
                }
                // root
                stack.push(node);
                stack.push(null);

            } else {
                // we have visited the node before this node
                node = stack.pop();
                res.add(node.key);
            }
        }

        return res;
    }

    private void preorderTraversalRecursion(Node<Key, Value> root, Queue<Key> keys) {
        if (root == null) {
            return;
        }

        // root -> left -> right
        keys.offer(root.key);
        if (root.left != null) {
            preorderTraversalRecursion(root.left, keys);
        }
        if (root.right != null) {
            preorderTraversalRecursion(root.right, keys);
        }
    }

    public Queue<Key> inorderTraversal(boolean isIteration) {
        if (isIteration) {
            return inorderTraversalIteration();
        } else {
            Queue<Key> keys = new LinkedList<>();
            inorderTraversalRecursion(root, keys);
            return keys;
        }
    }

    private Queue<Key> inorderTraversalIteration() {
        Queue<Key> res = new LinkedList<>();
        Stack<Node<Key, Value>> stack = new Stack<>();

        // In this iterative method, we are going to add null to identify whether we add this node into our res queue
        // or not.
        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            Node<Key, Value> node = stack.pop();

            if (node != null) {
                // Now we have not visited this node

                // right
                if (node.right != null) {
                    stack.push(root.right);
                }
                // root
                stack.push(node);
                stack.push(null);
                // left
                if (node.left != null) {
                    stack.push(root.left);
                }
            } else {
                // we have visited the node before this node
                node = stack.pop();
                res.add(node.key);
            }
        }

        return res;
    }

    private void inorderTraversalRecursion(Node<Key, Value> root, Queue<Key> keys) {
        if (root == null) {
            return;
        }

        // left -> root -> right
        if (root.left != null) {
            inorderTraversalRecursion(root.left, keys);
        }
        keys.offer(root.key);
        if (root.right != null) {
            inorderTraversalRecursion(root.right, keys);
        }
    }

    public Queue<Key> postorderTraversal(boolean isIteration) {
        if (isIteration) {
            return null;
        } else {
            Queue<Key> keys = new LinkedList<>();
            postorderTraversalRecursion(root, keys);
            return keys;
        }
    }

    private Queue<Key> postorderTraversalIteration() {
        Queue<Key> res = new LinkedList<>();
        Stack<Node<Key, Value>> stack = new Stack<>();

        // In this iterative method, we are going to add null to identify whether we add this node into our res queue
        // or not.
        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            Node<Key, Value> node = stack.pop();

            if (node != null) {
                // Now we have not visited this node

                // root
                stack.push(node);
                stack.push(null);
                // right
                if (node.right != null) {
                    stack.push(root.right);
                }
                // left
                if (node.left != null) {
                    stack.push(root.left);
                }
            } else {
                // we have visited the node before this node
                node = stack.pop();
                res.add(node.key);
            }
        }

        return res;
    }

    private void postorderTraversalRecursion(Node<Key, Value> root, Queue<Key> keys) {
        if (root == null) {
            return;
        }

        // left -> right -> root
        if (root.left != null) {
            postorderTraversalRecursion(root.left, keys);
        }
        if (root.right != null) {
            postorderTraversalRecursion(root.right, keys);
        }
        keys.offer(root.key);
    }

    public Queue<Key> levelTraversal() {
        Queue<Key> res = new LinkedList<>();
        Queue<Node<Key, Value>> levels = new LinkedList<>();

        if (root != null) {
            levels.offer(root);
        }

        while (!levels.isEmpty()) {
            Node<Key, Value> node = levels.poll();
            res.offer(node.key);

            if (node.left != null) {
                levels.offer(node.left);
            }
            if (node.right != null) {
                levels.offer(node.right);
            }
        }

        return res;
    }
}
