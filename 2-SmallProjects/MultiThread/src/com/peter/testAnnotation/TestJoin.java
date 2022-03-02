package com.peter.testAnnotation;

/**
 * Copyright (C), Peter GUAN
 * FileName: TestJoin
 * Author:   Peter
 * Date:     01/03/2022 10:17
 * Description:
 * History:
 * Version:
 */
public class TestJoin implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Thread VIP " + i);
        }
    }
    
    public static void main(String[] args) {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        for (int i = 0; i < 500; i++) {
            if (i == 200) {
                try {
                    thread.join(); // 插队 只有子线程运行结束之后 主线程才能运行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Main " + i);
        }
    }
}
