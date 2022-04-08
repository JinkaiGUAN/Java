package javaLearning.multiprocessLearning;

/**
 * Copyright (C), Peter GUAN
 * FileName: T01_HowToCreateThread
 * Author:   Peter
 * Date:     06/04/2022 11:18
 * Description:
 * History:
 * Version:
 * @author Peter
 */

/**
 * 启动线程的三种方式
 * 1. Extends Thread
 * 2. Implements Runnable interface
 * 3. Executors.newCachesThread
 * 4. Lambda expression
 */
public class T01_HowToCreateThread {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello MyThread!");
        }
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("MyRun!");
        }
    }

    public static void main(String[] args) {
        // 1st method
        new MyThread().start();
        Thread.currentThread();

        // 2nd method
        new Thread(new MyThread()).start();
        // or
        new Thread( () -> {
            System.out.println("Hello Lambda!");
        }).start();

    }
}

