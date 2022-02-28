package com.peter.main;

/**
 * Copyright (C), Peter GUAN
 * FileName: Race
 * Author:   Peter
 * Date:     28/02/2022 23:42
 * Description:
 * History:
 * Version:
 */
public class Race implements Runnable {

    private static String winner;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {

            if (Thread.currentThread().getName().equals("rabbit") && i % 10 == 0) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            boolean flag = gameOver(i);
            if (flag) {
                break;
            }

            System.out.println(Thread.currentThread().getName() + " finish " + i + " steps!");
        }
    }

    private boolean gameOver(int step) {
        if (winner != null) {
            return true;
        } else if (step >= 100) {
            winner = Thread.currentThread().getName();
            System.out.println("Winner is " + winner);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race, "rabbit").start();
        new Thread(race, "turtle").start();
    }
}
