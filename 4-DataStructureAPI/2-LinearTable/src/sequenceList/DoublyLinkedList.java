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

    /**
     * Insert an element in the doubly linked list.
     *
     * Note: The underlying mechanism is as follows,
     * 1. we need to take the first node into consideration.
     * 2. Find the previous node so that we can finish the insertion process.
     *
     * Exception:
     * 1. We must consider the situation when the index is larger than or equal to the total numbers we have now. For
     * this situation, we would like ot output a message tell that the user inout a wrong index. We take it into the
     * last node.
     *
     * @param i: The index where we are going to insert the new node.
     * @param t: The value of the inserted element.
     */
    public void insert(int i, T t) {
        // Insert the node in a certain position. We have to consider the following things: If the linked list is
        // empty, what if the linked list if not empty.
        Node newNode = new Node(t);

        if (i > N) {
            System.out.println("The input index " + t + "if out of boundary!");
            Node pre = last;
            pre.next = newNode;
            last = newNode;
            N++;
            return;
        }

        if (isEmpty()) {
            last = newNode;
            head.next = last;
            N++;
            return;
        }

        // find the position, where the inserting node should be followed
        Node pre = head;
        for (int idx = 0; idx < i - 1; i++) {
            pre = pre.next;
        }
        newNode.next = pre.next;
        pre.next = newNode;

        // add the node number
        N++;
    }

    /**
     * Remove the element in the certain position.
     *
     * Exception:
     * 1. If the input position is wrong, throw an exception.
     *
     * @param i: The index of the positon we are going to insert the element.
     * @return Return the value of the position.
     */
    public T remove(int i) {
        if (i >= N) {
            throw new IndexOutOfBoundsException("The index of " + i + "is out of boundary of " + N + "!" );
        }

        // find the previous node
        Node pre = head;
        for (int idx = 0; idx < i - 1; idx++) {
            pre = pre.next;
        }
        Node removedNode = pre.next;
        pre.next = pre.next.next;

        // update the element number
        N--;

        return removedNode.item;
    }

    /**
     * Give the index of the element.
     *
     * If we did not find the element, -1 would be returned.
     * @param t: The element value.
     * @return Return the index of the element.
     */
    public int indexOf(T t) {

        Node pre = head.next;
        for (int i = 0; i < N; i++) {
            // Comparable elements should  be used.
            // todo: Using comparable interface here
            if (pre.item == t) {
                return i;
            }
            pre = pre.next;
        }

        return -1;
    }

    public T getFirst() {
        if (isEmpty()) {
            return null;
        }

        return head.next.item;
    }

    public T getLast() {
        if (last == null) {
            return null;
        }

        return last.item;
    }


    // todo:implement for-loop
    @Override
    public Iterator<T> iterator() {
        return new DoublyLinkedListIterator();
    }

    private class DoublyLinkedListIterator implements Iterator<T> {
        private Node n = head;

        @Override
        public boolean hasNext() {
            return n.next == null;
        }

        @Override
        public T next() {
            n = n.next;
            return n.item;
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
