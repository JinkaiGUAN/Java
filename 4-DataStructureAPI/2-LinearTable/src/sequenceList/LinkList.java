package sequenceList;

import java.util.Iterator;

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

    private class Node<T> {
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

    public void clear() {

    }

    public boolean isEmpty() {

    }

    public int length() {}

    public T get(int i) {
        // get the i-th element in the linkedList, we start from 0 in the index
    }

    public void insert(T t) {
        // Add an element into the linkedList. Normally we insert such node after the dummy head.
    }

    public void insert(int i, T t) {
        // Overload the preceding insert function
    }

    public T remove(int i) {

    }

    public int indexOf(T t) {
        // If the element does not exist, return -1

        return -1;
    }

    // todo: Implement for loop interface
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class LinkedListIterator implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }

}


