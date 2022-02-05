package main.java;

/**
 * Copyright (C), Peter GUAN
 * FileName: OrderSymbolTable
 * Author:   Peter
 * Date:     05/02/2022 09:32
 * Description:
 * History:
 * Version:
 */
public class OrderSymbolTable<Key extends Comparable<Key>, Value> {

    private Node head;
    private int N;

    public OrderSymbolTable() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    public Value get(Key key) {
        return null;
    }


    public void put(Key key, Value val) {

    }

    public void delete(Key key) {

    }

    public int size() {
        return N;
    }

    class Node {
        public Value val;
        public Key key;
        public Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
}
