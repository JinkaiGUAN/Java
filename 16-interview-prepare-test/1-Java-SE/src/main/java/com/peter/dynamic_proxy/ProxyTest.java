package com.peter.dynamic_proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Copyright (C), Peter GUAN
 * FileName: ProxyTest
 * Author:   Peter
 * Date:     30/04/2022 10:42
 * Description:
 * History:
 * Version:
 */


public class ProxyTest {

    @Test
    public void testDynamicProxy() {
        JdkProxy proxy = new JdkProxy(new Student("Tom"));

        Person student = (Person) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), new Class[]{Person.class}
                , proxy);
        student.wakeup();
        student.sleep();

    }

}
