package com.peter.demo2_static_proxy;

/**
 * Copyright (C), Peter GUAN
 * FileName: UserServiceImpl
 * Author:   Peter
 * Date:     03/05/2022 08:33
 * Description:
 * History:
 * Version:
 */
public class UserServiceImpl implements UserService {


    @Override
    public void add() {
        System.out.println("add a user!");
    }

    @Override
    public void delete() {
        System.out.println("Delete a user!");
    }

    @Override
    public void update() {
        System.out.println("Update a user!");
    }

    @Override
    public void query() {
        System.out.println("Query a user!");
    }
}
