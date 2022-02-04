package test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import sequenceList.DoublyLinkedList;

/**
 * Copyright (C), Peter GUAN
 * FileName: DoublyLinkedListTest
 * Author:   Peter
 * Date:     03/02/2022 22:37
 * Description:
 * History:
 * Version:
 */
public class DoublyLinkedListTest {

    private DoublyLinkedList<String> list;

    @BeforeEach
    public void setUp() {
        list = new DoublyLinkedList<>();
        list.insert("Tom_0");
        list.insert("Tom_1");
        list.insert("Tom_2");
        list.insert("Tom_3");
        System.out.println("BeforeEach setup method called");
    }

    @Test
    @DisplayName("Test length")
    public void testLength() {
        Assert.assertEquals(4, list.length());
    }

    @Test
    @DisplayName("Test iterator")
    public void testIterator() {
        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    @DisplayName("Test clear")
    public void testClear() {
        list.clear();
        Assert.assertEquals(0, list.length());
    }

    @Test
    public void testIsEmpty() {
        Assert.assertFalse(list.isEmpty());
        list.clear();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testInsert() {
        list.insert(1, "Tom_5");
        list.insert(7, "Tom_6");
        Assert.assertEquals(5, list.length());
        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void testRemove() {
        Assert.assertEquals("Tom_3", list.remove(0));
        Assert.assertEquals("Tom_1", list.remove(1));

    }

    @Test
    public void testIndexOf() {
        Assert.assertEquals(1, list.indexOf("Tom_2"));
    }

    @Test
    public void testGetFirst() {
        Assert.assertEquals("Tom_3", list.getFirst());
    }

    @Test
    public void testGetLast() {
        Assert.assertEquals("Tom_0", list.getLast());
    }
}
