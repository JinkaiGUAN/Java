package com.peter.testReflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * Copyright (C), Peter GUAN
 * FileName: Test10
 * Author:   Peter
 * Date:     04/03/2022 09:28
 * Description: 反射操作注解
 * History:
 * Version:
 */
public class Test10 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.peter.testReflection.Student2");

        // 通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        // 获得注解value的值
        Table table = (Table) c1.getAnnotation(Table.class);
        String value = table.value();
        System.out.println(value);

        // 获得类的指定注解
        Field name = c1.getDeclaredField("name");
        TableField annotation = name.getAnnotation(TableField.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());


    }
}

@Table("dbStudent")
class Student2 {
    @TableField(columnName = "dbID", type = "int", length = 10)
    private int id;
    @TableField(columnName = "dbName", type = "varchar", length = 3)
    private String name;
    @TableField(columnName = "dbAge", type = "int", length = 10)
    private int age;

    public Student2(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

// create annotation

// 类名注解
@Target(ElementType.TYPE)  // 给类标注他是什么样的类
@Retention(RetentionPolicy.RUNTIME)
@interface Table {
    String value();
}

// 属性注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface TableField {
    String columnName();

    String type();

    int length();
}