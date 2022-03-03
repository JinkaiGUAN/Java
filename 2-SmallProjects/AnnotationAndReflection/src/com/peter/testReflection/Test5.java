package com.peter.testReflection;

/**
 * Copyright (C), Peter GUAN
 * FileName: Test5
 * Author:   Peter
 * Date:     03/03/2022 09:07
 * Description: 测试类什么时候会被初始化： 只有通过反射和new的时候类才会被初始化
 * History:
 * Version:
 */
public class Test5 {
    static {
        System.out.println("Main class");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // 1.主动引用
        // 直接初始化
//        Son son = new Son();

        // 通过反射, 消耗资源
//        Class c1 = Class.forName("com.peter.testReflection.Son");

        // 2. 不会产生类的引用方法
//        System.out.println(Son.b);

//        Son[] sons = new Son[2];

        // c常量不会引起子类父类的初始化
        System.out.println(Son.M);

    }

}

class Father {

    static int b;

    static {
        System.out.println("Father is loading");
    }
}

class Son extends Father {

    static {
        System.out.println("Son is loading");
        m = 300;
    }

    static int m = 100;
    static final int M = 1;

}