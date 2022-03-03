package com.peter.testReflection;

import java.lang.annotation.ElementType;

/**
 * Copyright (C), Peter GUAN
 * FileName: Test3
 * Author:   Peter
 * Date:     03/03/2022 08:40
 * Description: 所有类型的class
 * History:
 * Version:
 */
public class Test3 {

    public static void main(String[] args) {
        // 类
        Class c1 = Object.class;
        // 接口
        Class c2 = Comparable.class;
        //一维数组
        Class c3 = String[].class;
        //二维数组
        Class c4 = int[][].class;
        // 注解
        Class c5 = Override.class;
        // 枚举
        Class c6 = ElementType.class;
        // 基本数据类型
        Class c7 = Integer.class;
        // void
        Class c8 = void.class;
        // Class
        Class c9 = Class.class;

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);

        // 只要元素类型于维度一样， 就是同一个class
        int[] a =  new int[10];
        int[] b = new int[100];
        System.out.println(a.getClass().hashCode());
        System.out.println(b.getClass().hashCode());
    }
}
