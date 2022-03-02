package com.peter.testReflection;

/**
 * Copyright (C), Peter GUAN
 * FileName: Test2
 * Author:   Peter
 * Date:     02/03/2022 20:44
 * Description:
 * History:
 * Version:
 */
public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("This person is " + person.getName());

        // method 1, using instance
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        // method 2, forname
        Class c2 = Class.forName("com.peter.testReflection.Student");
        System.out.println(c2.hashCode());

        // method 3,通过类名 fromClass获得
        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        // method 4, 基本内置类型的包装类都有一个Type属性
        Class c4 = Integer.TYPE;
        System.out.println(c4.hashCode());

        // 获得父类类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5);

    }
}

class Person {
    private String name;

    public Person() {

    }
    public Person(String name) {
        this.name = name;
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
                "name='" + name + '\'' +
                '}';
    }
}


class Student extends Person {

    public Student() {
        this.setName("Student");
    }
}

class Teacher extends Person {
    public Teacher() {
        this.setName("Teacher");
    }
}


