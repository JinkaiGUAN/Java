package com.peter.serilise_object;

import java.io.Serializable;

/**
 * Copyright (C), Peter GUAN
 * FileName: Student
 * Author:   Peter
 * Date:     28/04/2022 10:28
 * Description:
 * History:
 * Version:
 */
public class Student implements Serializable {

    private String name;

    private static Integer age;
    private Integer score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
