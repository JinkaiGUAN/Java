package com.peter.testReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Copyright (C), Peter GUAN
 * FileName: Test8
 * Author:   Peter
 * Date:     03/03/2022 11:11
 * Description: 通过反射 动态地创建对象
 * History:
 * Version:
 */
public class Test8 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        Class c1 = Class.forName("com.peter.testReflection.User");

//        User user = (User) c1.newInstance(); // 必须有无参构造器
//        System.out.println(user);

        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User u2 = (User) constructor.newInstance("Jon", 001, 18);
        System.out.println(u2);

        // 调用方法
        Method setName =  c1.getDeclaredMethod("setName", String.class);
        setName.invoke(u2, "Ka");
        System.out.println(u2.getName());

        // 操作属性
        Field age = c1.getDeclaredField("age");
        age.setAccessible(true);  // private 修饰地field需要开启访问权限， 如果反射经常使用， 可以关闭该检测
        age.set(u2, 19);
        System.out.println(u2.getAge());
    }
}
