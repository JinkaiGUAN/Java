package com.peter.test;

import javax.sound.midi.Soundbank;

/**
 * Copyright (C), Peter GUAN
 * FileName: TestDaemon
 * Author:   Peter
 * Date:     01/03/2022 10:49
 * Description:
 * History:
 * Version:
 */
public class TestDaemon {
    public static void main(String[] args) {
        Person person = new Person();
        God god = new God();

        Thread thread = new Thread(god);
        thread.setDaemon(true);
        thread.start();

        new Thread(person).start();
    }

}

class God implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("God is blessing");
        }
    }
}

class Person implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("Be happy!");
        }
        System.out.println("-------------- Goodbye ------------------");
    }
}