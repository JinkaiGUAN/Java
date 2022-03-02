package com.peter.main.producerAndConsumer;

/**
 * Copyright (C), Peter GUAN
 * FileName: PCBuffer
 * Author:   Peter
 * Date:     02/03/2022 11:26
 * Description: 利用管程法实现producer and consumer problem， 即使用缓冲区来解决
 * History:
 * Version:
 */
public class PCBuffer {

    public static void main(String[] args) {
        SynContainer container = new SynContainer();

        new Producer(container).start();
        new Consumer(container).start();
    }

}


class Producer extends Thread {

    SynContainer container;

    public Producer (SynContainer container) {
        this.container = container;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("Produce chick No. " + i );
        }
    }
}

class Consumer extends Thread {
    SynContainer container;

    public Consumer (SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Consume ---> chick No. " + container.pop().getId());
        }
    }
}

class Chicken {
    private int id;

    public Chicken(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

// buffer
class SynContainer {
    // 容器大小
    Chicken[] chickens = new Chicken[10];
    private int count = 0;

    // 生产者生产产品， 加入synchronized的原因是我们要同步， 不能让生产数量有问题
    public synchronized void push (Chicken chicken) {
        // 如果容器满了 就要通知消费者
        if (count == chickens.length) {
            // 生产等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 容器没有满， 继续生产
        chickens[count] = chicken;
        count++;

        this.notifyAll();
    }

    // 消费者消耗产品
    public synchronized Chicken pop() {
        if (count == 0) {
            // 没有产品， 通知producer
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Chicken chicken = chickens[--count];

        this.notifyAll();

        return chicken;
    }

}