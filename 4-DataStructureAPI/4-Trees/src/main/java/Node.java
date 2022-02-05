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
    public Node left;
    public Node right;
    public Key key;
    public Value val;

    public Node(Key key, Value val, Node left, Node right) {
        this.key = key;
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
