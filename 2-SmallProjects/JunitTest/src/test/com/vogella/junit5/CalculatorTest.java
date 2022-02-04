package test.com.vogella.junit5;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import main.com.vogella.junit5.Calculator;

/**
 * Copyright (C), Peter GUAN
 * FileName: CalculatorTest
 * Author:   Peter
 * Date:     04/02/2022 14:00
 * Description:
 * History:
 * Version:
 */
public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {calculator = new Calculator();}

    @Test
    @DisplayName("Simple multiplication should work")
    void testMultiply() {
        Assert.assertEquals(20, calculator.multiply(4, 5));
    }
}
