package com.peter.demo4_dynamic_proxy;

/**
 * Copyright (C), Peter GUAN
 * FileName: Client
 * Author:   Peter
 * Date:     03/05/2022 08:41
 * Description:
 * History:
 * Version:
 */
public class Client {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setTarget(userService);

        UserService proxy = (UserService) pih.getProxy();

        proxy.add();
    }
}
