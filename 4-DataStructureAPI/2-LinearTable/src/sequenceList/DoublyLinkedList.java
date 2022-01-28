package sequenceList;

import java.util.Iterator;

/**
 * Copyright (C), Peter GUAN
 * FileName: DoublyLinkedList
 * Author:   Peter
 * Date:     26/01/2022 09:53
 * Description:
 * History:
 * Version:
 */
public class DoublyLinkedList<T> implements Iterable<T> {
    // This is the doubly linked list API. In this API, you should be careful to the head and last node, since the head
    // can be the dummy head, while the last node is not the dummy tail.

    private Node head;  // dummy head
    private Node last; // the last node
    private int N;  // the length, including last node.

    public DoublyLinkedList() {
        this.head = new Node(null, null, null);
        this.last = null;
        this.N = 0;
    }

    public void clear() {
        // Clear the doubly linked list. First time, we need to set the dummy head point to null and last node to
        // null. Then we will assign the length of the linked list to 0.
        last = null;
        head.next = null;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int length() {
        return N;
    }

    public T get(int i) {
        return null;
    }

    public void insert(T t) {
        // Insert a node at the head. Here are are going to call the overloading function to insert at the index of 0.
        insert(0, t);
    }

    public void insert(int i, T t) {
        // Insert the node in a certain position. We have to consider the following things: If the linked list is
        // empty, what if the linked list if not empty.
        Node newNode = new Node(t);
        if (isEmpty()) {
            last = newNode;
            head.next = last;
        }

        // find the position to be inserted
        for (int idx = 0; idx < i - 1; i++) {

        }


        // add the node number
        N++;
    }

    public T remove(int i) {
        return null;
    }

    public int indexOf(T t) {
        return -1;
    }

    public T getFirst() {
        if (isEmpty()) {
            return null;
        }

        return head.next.item;
    }

    public T getLast() {

        return null;
    }


    // todo:implement for-loop
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class DoublyLinkedListIterator implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }

    private class Node {
        // please note that we cannot use general type in the inner class.
        public T item;
        public Node next;
        public Node pre;

        public Node() {}

        public Node(T item) {
            this.item = item;
            pre = null;
            next = null;
        }

        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }
}
