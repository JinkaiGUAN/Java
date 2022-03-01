package com.peter.main;

/**
 * Copyright (C), Peter GUAN
 * FileName: StaticProxy
 * Author:   Peter
 * Date:     01/03/2022 00:08
 * Description:
 * History:
 * Version:
 */
public class StaticProxy {

    public static void main(String[] args) {
        new Thread( () -> System.out.println("I love you")).start();

        // Thread模块调用Runnable接口， 即Runnable接口的实现类通过静态代理 来实现多线程
    }
}

