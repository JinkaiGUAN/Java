package com.peter.demo2_static_proxy;

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
        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(userService);

        proxy.add();
    }
}
