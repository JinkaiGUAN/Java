package com.peter;

import org.junit.Assert;
import org.junit.Test;

/**
 * Copyright (C), Peter GUAN
 * FileName: DemoTest
 * Author:   Peter
 * Date:     04/02/2022 09:38
 * Description:
 * History:
 * Version:
 */
public class DemoTest {
    @Test
    public void testSay() {
        Demo d = new Demo();
        String outString = d.say("Tom");
        Assert.assertEquals("Hello Tom", outString);
    }

}
