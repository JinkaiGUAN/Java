package com.peter.serilise_object.demo1;

import java.io.Serializable;

/**
 * Copyright (C), Peter GUAN
 * FileName: Person
 * Author:   Peter
 * Date:     28/04/2022 10:42
 * Description:
 * History:
 * Version:
 */
public class Person implements Serializable {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
