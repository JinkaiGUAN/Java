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

    private Node head;  // dummy head
    private Node last; // the last node
    private int N;  // the length, including last node.

    public DoublyLinkedList() {
        this.head = new Node(null, null, null);
        this.last = null;
        this.N = 0;
    }

    public void clear() {

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

    }

    public void insert(int i, T t) {

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
