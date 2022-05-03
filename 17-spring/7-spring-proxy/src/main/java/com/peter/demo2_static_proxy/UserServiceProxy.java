package com.peter.demo2_static_proxy;

/**
 * Copyright (C), Peter GUAN
 * FileName: UserServiceProxy
 * Author:   Peter
 * Date:     03/05/2022 08:36
 * Description:
 * History:
 * Version:
 */
public class UserServiceProxy implements UserService {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void log(String msg) {
        System.out.println("Implement " + msg + " method!");
    }

    @Override
    public void add() {
        userService.add();
        log("add");
    }

    @Override
    public void delete() {
        userService.delete();
        log("delete");
    }

    @Override
    public void update() {
        userService.update();
        log("update");
    }

    @Override
    public void query() {
        userService.query();
        log("query");
    }
}
