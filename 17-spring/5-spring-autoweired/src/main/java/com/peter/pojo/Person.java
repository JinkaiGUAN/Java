package com.peter.pojo;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright (C), Peter GUAN
 * FileName: Person
 * Author:   Peter
 * Date:     01/05/2022 12:04
 * Description:
 * History:
 * Version:
 */
public class Person {

    @Autowired
    private Cat cat;
    @Autowired
    private Dog dog;
    private String name;

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }
}
