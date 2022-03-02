package com.peter.main.producerAndConsumer;

/**
 * Copyright (C), Peter GUAN
 * FileName: PCFlag
 * Author:   Peter
 * Date:     02/03/2022 11:44
 * Description: 通过使用信号法来解决PC问题
 * History:
 * Version:
 */
public class PCFlag {
    public static void main(String[] args) {
        TV tv = new TV();

        Actor actor = new Actor(tv);
        Audience audience = new Audience(tv);

        actor.start();
        audience.start();

    }
}


class Actor extends Thread {
    TV tv;

    public Actor(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                this.tv.play("Video - " + i);
            } else {
                this.tv.play("Ad - " + i);
            }
        }
    }

}

class Audience extends Thread {
    TV tv;

    public Audience(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.tv.watch();
        }
    }

}

class TV {
    // 演员表演的时候， 观众等待 T， 观众看的时候， 演员等待 F
    String voice;
    boolean flag = true; //

    // act
    public synchronized void play(String voice) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Actor : " + voice);
        this.voice = voice;
        this.flag = !this.flag;
        this.notifyAll();

    }

    // watch
    public synchronized void watch() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Audience : " + this.voice);
        this.flag = !this.flag;
        this.notifyAll();

    }

}