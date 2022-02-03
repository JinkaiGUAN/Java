package sequenceList;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Copyright (C), Peter GUAN
 * FileName: LinkList
 * Author:   Peter
 * Date:     26/01/2022 09:40
 * Description:
 * History:
 * Version:
 */
public class LinkList<T> implements Iterable<T> {
    private Node head;  // head node -> dummy head
    private int N;  // the length of the linkedList.

    public LinkList() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    public void clear() {
        head.next = null;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int length() {return N;}

    public T get(int i) {
        // get the i-th element in the linkedList, we start from 0 in the index
        if (i >= N || i < 0) {
            throw new IndexOutOfBoundsException("The index of " + i + " is out of boundary of " + N + "!");
        }

        Node pre = head.next;
        for (int idx = 0; idx < i; idx++) {
            pre = pre.next;
        }

        return pre.item;
    }

    public void insert(T t) {
        // Add an element into the linkedList. Normally we insert such node after the dummy head.
        Node newNode = new Node(t);
        Node cur = head.next;
        //  insert the node
        head.next = newNode;
        newNode.next = cur;
        N++;
    }

    /**
     * Insert an element at the certain position.
     *
     * Note: Here we are going to consider when the index i == N. We must test this function in our test class.
     *
     * @param i: Index。
     * @param t: Value.
     */
    public void insert(int i, T t) {
        // Overload the preceding insert function
        Node newNode = new Node(t);

        if (i > N || i < 0) {
            throw new IndexOutOfBoundsException("The index of " + i + " is out of boundary of " + N + "!");
        }

        // find the previous node
        Node pre = head;
        for (int idx = 0; idx < i; idx ++) {
            pre = pre.next;
        }

        Node lastNode = pre.next;
        pre.next = newNode;
        newNode.next = lastNode;
        N++;
    }

    public T remove(int i) {
        if (i >= N || i < 0) {
            throw new IndexOutOfBoundsException("The index of " + i + " is out of boundary of " + N + "!")
        }

        Node pre = head;
        for (int idx = 0; idx < i; idx++) {
            pre = pre.next;
        }
        // delete the node
        Node removedNode = pre.next;
//        removedNode.next = null;
        pre.next = pre.next.next;

        N--;

        return removedNode.item;
    }

    public int indexOf(T t) {
        // If the element does not exist, return -1
        Node cur = head;
        for (int i = 0; i < N; i++) {
            cur = cur.next;
            if (cur.item.equals(t)) {
                return i;
            }
        }

        return -1;
    }

    // todo: Implement for loop interface
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node n;

        public LinkedListIterator() {
            n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            n = n.next;
            return n.item;
        }
    }

    private class Node{
        public T item;
        public Node next;

        public Node() {}

        public Node(T item) {
            this.item = item;
            next = null;
        }

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }


    }

}


