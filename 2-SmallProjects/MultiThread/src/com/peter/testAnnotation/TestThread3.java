package com.peter.testAnnotation;

/**
 * Copyright (C), Peter GUAN
 * FileName: TestThread3
 * Author:   Peter
 * Date:     28/02/2022 23:11
 * Description: Implement Runnable interface, override run method. Put the thread into the implemented runnable class.
 * History:
 * Version:
 */
public class TestThread3 implements Runnable {
    /***
     * 避免单继承的局限性， 可以将一个对象交给多个线程使用
     */

    @Override
    public void run() {
        for (int i = 0; i < 20; i ++) {
            System.out.println("Learning code --" + i);
        }
    }

    public static void main(String[] args) {
        // 创建runnable接口的实现类对象
        TestThread3 t1 = new TestThread3();
        new Thread(t1).start();

        for (int i = 0; i < 20; i ++) {
            System.out.println("Learning thread -- " + i);
        }
    }
}
