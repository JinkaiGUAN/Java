package com.peter.test;

import org.junit.internal.runners.statements.RunAfters;

/**
 * Copyright (C), Peter GUAN
 * FileName: TestPriority
 * Author:   Peter
 * Date:     01/03/2022 10:32
 * Description:
 * History:
 * Version:
 */
public class TestPriority {
    public static void main(String[] args) {
        /**
         * 优先级高的线程有高概率会被cpu调度
         */

        // main
        System.out.println(Thread.currentThread().getName() + " --> " + Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();
        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);

        // 先设置优先级 在启动
        t1.start();
        t2.setPriority(1);
        t2.start();
        t3.setPriority(4);
        t3.start();
        t4.setPriority(7);
        t4.start();
        t5.setPriority(Thread.MAX_PRIORITY);
        t5.start();

    }
}

class MyPriority implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " --> " + Thread.currentThread().getPriority());
    }
}
