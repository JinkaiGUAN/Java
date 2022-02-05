package main.java;

import java.util.Queue;

/**
 * Copyright (C), Peter GUAN
 * FileName: BinarySearchTree
 * Author:   Peter
 * Date:     05/02/2022 09:40
 * Description: In this binary searching tree, we have key and value. Key will be used to sort the tree, and value
 * will be used as teh output when we use traversal methods.
 * History:
 * Version:
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private Node root;
    private int N;

    public BinarySearchTree() {
        this.root = null;
        this.N = 0;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node root, Key key, Value val) {
        //给指定树x上，添加键一个键值对，并返回添加后的新树
        return null;
    }

    public Value get(Key key) {
        return null;
    }

    public void delete(Key key) {
    }

    private Node delete(Node root, Key key) {
        //删除指定树x上的键为key的键值对，并返回删除后的新树
        return null;
    }

    public Key min() {
        return null;
    }

    private Node min(Node root) {
        return null;
    }

    public Key max() {
        return null;
    }

    private Node max(Node root) {
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
