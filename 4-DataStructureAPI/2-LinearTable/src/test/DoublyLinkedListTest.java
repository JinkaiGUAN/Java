package test;

import org.junit.Assert;
import org.junit.Test;
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

//    @BeforeEach
    public void setUp() {
        list = new DoublyLinkedList<>();
        list.insert(0,"Tom_0");
        list.insert(1,"Tom_1");
        list.insert(2,"Tom_2");
        list.insert(3,"Tom_3");
        System.out.println("BeforeEach setup method called");
    }

    @Test
    @DisplayName("Test length")
    public void testLength() {
        setUp();
        Assert.assertEquals(4, list.length());
    }



}
