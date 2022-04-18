package com.peter.linearTable;

/**
 * Copyright (C), Peter GUAN
 * FileName: SingleLinkedList
 * Author:   Peter
 * Date:     15/04/2022 16:47
 * Description:
 * History:
 * Version:
 *
 * @author: Peter
 */
public class SingleLinkedList<E> {
    private int size;
    private SingleLinkedListNode first;
    private SingleLinkedListNode last;

    public SingleLinkedList() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    /**
     * Add element.
     * @param e
     */
    public void add(E e) {
           
    }

    public E pop() {

    }

    /**
     * Delete the element according to the index.
     * @param index
     * @return
     */
    public E pop(int index) {

    }
}


class SingleLinkedListNode<E> {
    E val;
    SingleLinkedListNode next = null;

    public SingleLinkedListNode(E val) {
        this.val = val;
    }
}