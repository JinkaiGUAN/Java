package main.java;

/**
 * Copyright (C), Peter GUAN
 * FileName: Node
 * Author:   Peter
 * Date:     05/02/2022 09:38
 * Description:
 * History:
 * Version:
 */
public class Node<Key, Value> {
    public Node<Key, Value> left;
    public Node<Key, Value> right;
    public Key key;
    public Value val;

    public Node(Key key, Value val, Node<Key, Value> left, Node<Key, Value> right) {
        this.key = key;
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
