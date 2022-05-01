package com.peter.pojo;

/**
 * Copyright (C), Peter GUAN
 * FileName: User
 * Author:   Peter
 * Date:     28/04/2022 20:34
 * Description:
 * History:
 * Version:
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
