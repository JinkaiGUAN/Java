package com.peter.testAnnotation;

/**
 * Copyright (C), Peter GUAN
 * FileName: TestYield
 * Author:   Peter
 * Date:     01/03/2022 10:09
 * Description:
 * History:
 * Version:
 */
public class TestYield {


    public static void main(String[] args) {
        /**
         * 1. 礼让线程， 让当前正在执行的线程暂停， 但不阻塞
         * 2.  将线程从运行状态 转变为就绪状态
         * 3. cpu重新调度， 礼让但不一定成功， 看cpu心情
         *
         */
        MyYield myYield = new MyYield();

        new Thread(myYield, "A").start();
        new Thread(myYield, "B").start();

    }
}

class MyYield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " thread is running!");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + " thread stooped!");
    }
}