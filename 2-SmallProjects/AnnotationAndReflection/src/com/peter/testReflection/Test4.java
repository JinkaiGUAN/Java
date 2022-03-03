package com.peter.testReflection;

/**
 * Copyright (C), Peter GUAN
 * FileName: Test4
 * Author:   Peter
 * Date:     03/03/2022 08:51
 * Description: 类如何被加载
 * History:
 * Version:
 */
public class Test4 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
        /**
         * 1. 加载到内存， 会产生一个类对应的class对象
         * 2. 链接， 连接结束后 m = 0
         * 3. 初始化
         *  <clinit>() {
         *      System.out.println("A 静态代码块初始化");
         *         m = 300;
         *         M = 100;
         *      }
         *
         *
         */
    }
}


class A {
    static {
        System.out.println("A 静态代码块初始化");
        m = 300;
    }

    static int m = 100;

    public A() {
        System.out.println("A的无参构造初始化");
    }

}