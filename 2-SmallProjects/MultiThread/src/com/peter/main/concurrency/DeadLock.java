package com.peter.main.concurrency;

/**
 * Copyright (C), Peter GUAN
 * FileName: DeadLock
 * Author:   Peter
 * Date:     02/03/2022 11:05
 * Description: 死锁 - 多个线程互相抱着对方所需要的资源， 然后形成僵持
 * History:
 * Version:
 */
public class DeadLock {
    public static void main(String[] args) {
        MakeUp g1 = new MakeUp(0, "g1");
        MakeUp g2 = new MakeUp(1, "g2");

        g1.start();
        g2.start();
    }
}


class LipStick {

}

class Mirror {

}

class MakeUp extends Thread {

    // 需要的资源只有一份， 用static来保证只有一份
    private static LipStick lipStick = new LipStick();
    private static Mirror mirror = new Mirror();
    private int choice;  // 选择
    private String name;

    MakeUp (int choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        try {
//            makeUp();
            makeUpUpdate();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 互相持有对方的锁， 就是需要拿到对方的资源
    private void makeUp() throws InterruptedException {
        if (choice == 0) {
            synchronized (lipStick) { // 获得口红的锁
                System.out.println(this.name + " gets the lipstick!");

                Thread.sleep(100);
                synchronized (mirror) { // 获得镜子的锁
                    System.out.println(this.name + " gets the mirror!");
                }
            }
        } else {
            synchronized (mirror) { // 获得镜子的锁
                System.out.println(this.name + " gets the mirror!");
                Thread.sleep(100);
                synchronized (lipStick) { // 获得口红的锁
                    System.out.println(this.name + " gets the lipstick!");
                }
            }
        }
    }

    private void makeUpUpdate() throws InterruptedException {
        if (choice == 0) {
            synchronized (lipStick) { // 获得口红的锁
                System.out.println(this.name + " gets the lipstick!");

                Thread.sleep(100);
            }
            synchronized (mirror) { // 获得镜子的锁
                System.out.println(this.name + " gets the mirror!");
            }
        } else {
            synchronized (mirror) { // 获得镜子的锁
                System.out.println(this.name + " gets the mirror!");
                Thread.sleep(100);
            }
            synchronized (lipStick) { // 获得口红的锁
                System.out.println(this.name + " gets the lipstick!");
            }
        }
    }
}