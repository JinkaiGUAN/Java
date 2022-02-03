package com.peter;

import org.junit.Test;
import org.junit.Assert;

public class DemoTest {

    @Test
    public void testSay() {
        Demo d = new Demo();
        String ret = d.say("say");
        Assert.assertEquals("Hello say", ret);
    }
}