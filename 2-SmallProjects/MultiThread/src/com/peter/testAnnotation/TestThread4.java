package com.peter.testAnnotation;

/**
 * Copyright (C), Peter GUAN
 * FileName: TestThread4
 * Author:   Peter
 * Date:     28/02/2022 23:20
 * Description: Using multiple threads to control one object
 * History:
 * Version:
 */
public class TestThread4 implements Runnable {
    private int ticketNum = 10;

    @Override
    public void run() {
        // 此处同时操作 ticketNum 会引起资源不安全
        while (true) {
            if (ticketNum <= 0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " gets ticket num " + ticketNum--);
        }
    }

    public static void main(String[] args) {
        TestThread4 t1 = new TestThread4();

        new Thread(t1, "Sim").start();
        new Thread(t1, "john").start();
        new Thread(t1, "Eva").start();
    }
}
