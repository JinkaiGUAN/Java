package com.peter.testReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
//import java.lang.reflect.Method;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Copyright (C), Peter GUAN
 * FileName: Test7
 * Author:   Peter
 * Date:     03/03/2022 10:54
 * Description: 获取类的信息
 * History:
 * Version:
 */
public class Test7 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("com.peter.testReflection.User");

        // 获得类的名字
        System.out.println(c1.getName());  // package + classname
        System.out.println(c1.getSimpleName()); // classname

        User user = new User("id", 1, 1);
        Class c2 = user.getClass();
        System.out.println(c2.getName());  // package + classname
        System.out.println(c2.getSimpleName()); // classname

        // 获得属性
        Field[] fields  = c1.getFields(); // 只能找到public方法
        System.out.println(Arrays.toString(fields));

        fields = c1.getDeclaredFields();
        System.out.println(Arrays.toString(fields));

        // 获取指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        // 获得类的方法
        Method[] methods = c1.getDeclaredMethods(); // 获得本类的所有方法
        System.out.println(Arrays.toString(methods));

        methods = c1.getMethods(); // 获得本类和基类的所有public方法
        System.out.println(Arrays.toString(methods));

        // 获得指定方法
        Method getName = c1.getMethod("getName", null);
        System.out.println(getName);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(setName);

        // 获得指定的构造器
        Constructor[] constructors = c1.getConstructors();
        System.out.println(Arrays.toString(constructors));
        constructors = c1.getDeclaredConstructors();
        System.out.println(Arrays.toString(constructors));



    }
}
