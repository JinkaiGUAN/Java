package com.peter.pojo;

/**
 * Copyright (C), Peter GUAN
 * FileName: Hello
 * Author:   Peter
 * Date:     28/04/2022 19:18
 * Description:
 * History:
 * Version:
 */
public class Hello {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "name='" + name + '\'' +
                '}';
    }

    public void show() {
        System.out.println("Hello " + name);
    }
}
