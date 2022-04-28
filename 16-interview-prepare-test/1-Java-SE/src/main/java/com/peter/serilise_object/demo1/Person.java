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
    private static final long serialVersionUID = 1L;

    private String name;
    /**
     * 静态不能背序列化
     */
    private static int age;

    private transient int score;

    private int id;

    public Person() {
    }

    public Person(String name, int age, int score, int id) {
        this.name = name;
        Person.age = age;
        this.score = score;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", age=" + Person.age +
                ", id=" + id +
                '}';
    }
}
