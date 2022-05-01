package com.peter.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Copyright (C), Peter GUAN
 * FileName: JdkProxy
 * Author:   Peter
 * Date:     30/04/2022 10:38
 * Description:
 * History:
 * Version:
 */
public class JdkProxy implements InvocationHandler {

    private Object bean;

    public JdkProxy(Object bean) {
        this.bean = bean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();

        if (methodName.equals("wakeup")) {
            System.out.println("早安!");
        } else if (methodName.equals("sleep")) {
            System.out.println("晚安！");
        }

        return method.invoke(bean, args);
    }
}
