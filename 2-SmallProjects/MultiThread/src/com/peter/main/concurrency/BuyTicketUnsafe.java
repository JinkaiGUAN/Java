package com.peter.main.concurrency;

/**
 * Copyright (C), Peter GUAN
 * FileName: BuyTicketUnsafe
 * Author:   Peter
 * Date:     02/03/2022 10:08
 * Description: 不安全买票， 即会出现资源争抢. 线程不安全 有负数， 或者拿到同一张票.
 * Thread和Runnable的实质是继承关系，没有可比性。无论使用Runnable还是Thread，都会new Thread，然后执行run方法。用法上，
 * 如果有复杂的线程操作需求，那就选择继承Thread，如果只是简单的执行一个任务，那就实现runnable。
 * 但是通常来说， Runnable更容易实现资源共享。 不过只要在Thread继承的子类中的共享资源加上static， 也可以实现资源共享。
 * History:
 * Version:
 */
public class BuyTicketUnsafe {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket).start();
        new Thread(buyTicket).start();
        new Thread(buyTicket).start();

    }
}

class BuyTicket implements Runnable {

    private int ticketNum = 10;

    @Override
    public void run() {
        //  but ticket
        while (true) {
            if (ticketNum > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " get ticket No " + ticketNum--);
            } else {
                break;
            }
        }
    }
}