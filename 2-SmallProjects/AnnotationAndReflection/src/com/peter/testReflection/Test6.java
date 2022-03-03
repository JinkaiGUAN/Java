package com.peter.testReflection;

/**
 * Copyright (C), Peter GUAN
 * FileName: Test6
 * Author:   Peter
 * Date:     03/03/2022 09:23
 * Description: 获取类加载器
 * History:
 * Version:
 */
public class Test6 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 获取系统类加载器的父类加载器 --》 扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        // 获取扩展类加载器的父类加载器 --》 根加载器（c/c++）, 读不出 为null
        ClassLoader root = parent.getParent();
        System.out.println(root);

        // 测试当前类是那个类加载器加载的 --》 用户类的的加载器

        ClassLoader classLoader = Class.forName("com.peter.testReflection.Test6").getClassLoader();
        System.out.println(classLoader);

        // 测试JDK内置的类是谁加载的，  -- 》 根加载器加载的，所以是null
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);

        // 获取系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
        /**
         * E:\JavaCode\skeleton-sp19-master\library-sp19\javalib\algs4.jar;
         * E:\JavaCode\skeleton-sp19-master\library-sp19\javalib\hamcrest-core-1.3.jar;
         * E:\JavaCode\skeleton-sp19-master\library-sp19\javalib\jh61b.jar;
         * E:\JavaCode\skeleton-sp19-master\library-sp19\javalib\junit-4.12.jar;
         * E:\JavaCode\skeleton-sp19-master\library-sp19\javalib\stdlib-package.jar;
         * E:\JavaCode\skeleton-sp19-master\library-sp19\javalib\stdlib.jar;
         * E:\JavaCode\skeleton-sp19-master\library-sp19\javalib\xchart-3.5.1.jar;
         * E:\SoftwareDevelopmentJava\2-SmallProjects\out\production\AnnotationAndReflection
         */

    }
}
