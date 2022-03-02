package com.peter.testAnnotation;

/**
 * Copyright (C), Peter GUAN
 * FileName: TestState
 * Author:   Peter
 * Date:     01/03/2022 10:24
 * Description:
 * History:
 * Version:
 */
public class TestState {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("------------");
        });

        // new
        Thread.State state = thread.getState();
        System.out.println(state);

        // run
        thread.start();
        state = thread.getState();
        System.out.println(state);

        // blocked or terminated
        while (state != Thread.State.TERMINATED) {
            try {
                Thread.sleep(100);
                state = thread.getState();
                System.out.println(state);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
