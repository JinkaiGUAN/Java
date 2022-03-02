package com.peter.testAnnotation;

/**
 * Copyright (C), Peter GUAN
 * FileName: TestThread
 * Author:   Peter
 * Date:     28/02/2022 22:36
 * Description:
 * History:
 * Version:
 */
public class TestThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 20; i ++) {
            System.out.println("Learning code --" + i);
        }
    }

    public static void main(String[] args) {
        // main thread
        TestThread test1 = new TestThread();
        test1.start();


        for (int i = 0; i < 20; i ++) {
            System.out.println("Learning thread -- " + i);
        }
    }
}
