package test.java;

import main.java.BinarySearchTree;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

/**
 * Copyright (C), Peter GUAN
 * FileName: BinarySearchTreeTest
 * Author:   Peter
 * Date:     16/02/2022 17:25
 * Description: This is the test class for BinarySearchTree class.
 * History:
 * Version:
 */
public class BinarySearchTreeTest {
    private BinarySearchTree<String, Integer> bst;

    @BeforeEach
    public void setUp() {
        bst = new BinarySearchTree<>();

        bst.put("Jon", 1);
        bst.put("Tom", 2);
        bst.put("Jess", 3);
    }

    @Test
    @DisplayName("Test insert")
    public void testInsert() {

    }


}
