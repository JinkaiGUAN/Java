package com.peter.demo4_dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Copyright (C), Peter GUAN
 * FileName: UserServiceProxy
 * Author:   Peter
 * Date:     03/05/2022 08:36
 * Description:
 * History:
 * Version:
 */
public class ProxyInvocationHandler implements InvocationHandler {

    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public void log(String msg) {
        System.out.println("Implement " + msg + " method!");
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        Object result = method.invoke(target, args);

        return result;
    }
}
