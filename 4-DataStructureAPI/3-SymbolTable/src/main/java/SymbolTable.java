package main.java;

/**
 * Copyright (C), Peter GUAN
 * FileName: SymbolTable
 * Author:   Peter
 * Date:     05/02/2022 09:25
 * Description:
 * History:
 * Version:
 */
public class SymbolTable<Key, Value> {

    //记录首结点
    private Node head;
    //记录符号表中元素的个数
    private int N;

    public SymbolTable() {
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


    /**
     * Inner Node class.
     */
    class Node {
        public Key key;
        public Value val;
        public Node next;

        public Node() {}

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
}
