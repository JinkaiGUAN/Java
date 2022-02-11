package main.java;

import java.util.Queue;

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
            Node<Key, Value> minNode = root;
            while (minNode != null) {
                minNode = minNode.left;
            }

        }

        return root;
    }

    public Key min() {
        return null;
    }

    private Node<Key, Value> min(Node<Key, Value> root) {
        return null;
    }

    public Key max() {
        return null;
    }

    private Node<Key, Value> max(Node<Key, Value> root) {
        return null;
    }

    public int size() {
        return N;
    }

    // The following parts are traversal method achievements, where recursion and iteration ideas are being used.
    public Queue<Value> preorderTraversal() {
        return null;
    }

    public Queue<Value> inorderTraversal() {
        return null;
    }

    public Queue<Value> postorderTraversal() {
        return null;
    }

    public Queue<Value> levelTraversal() {
        return null;
    }
}
