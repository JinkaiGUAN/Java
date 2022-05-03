package com.peter.demo3_dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Copyright (C), Peter GUAN
 * FileName: Proxy
 * Author:   Peter
 * Date:     03/05/2022 08:24
 * Description:
 * History:
 * Version:
 */
public class ProxyInvocationHandler implements InvocationHandler {

    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    /**
     * 生成代理类，重点是第二个参数，获取要代理的抽象角色！之前都是一个角色，现在可以代理一类角色
     * @return
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
    }

    public void checkHouse() {
        System.out.println("带房客看房！");
    }

    public void fare() {
        System.out.println("收中介费！");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        checkHouse();
        // Important: use reflection
        Object result = method.invoke(rent, args);
        fare();

        return result;
    }
}
