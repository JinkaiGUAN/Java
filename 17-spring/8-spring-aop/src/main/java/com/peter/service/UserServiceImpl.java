package com.peter.service;

/**
 * Copyright (C), Peter GUAN
 * FileName: UserServiceImpl
 * Author:   Peter
 * Date:     04/05/2022 08:47
 * Description:
 * History:
 * Version:
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("Add user!");
    }

    @Override
    public void delete() {
        System.out.println("Delete user!");
    }

    @Override
    public void update() {
        System.out.println("Update user!");
    }

    @Override
    public void search() {
        System.out.println("Search user!");
    }
}
