package com.peter.dynamic_proxy;

/**
 * Copyright (C), Peter GUAN
 * FileName: Student
 * Author:   Peter
 * Date:     30/04/2022 10:35
 * Description:
 * History:
 * Version:
 */
public class Student implements Person{

    private String name;

    public Student() {

    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void wakeup() {
        System.out.println("Student " + name + "  wake up, please!");
    }

    @Override
    public void sleep() {
        System.out.println("Student " + name + "  sleep, please!");
    }
}
