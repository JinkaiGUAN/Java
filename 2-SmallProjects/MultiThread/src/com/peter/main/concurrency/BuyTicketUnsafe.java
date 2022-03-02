package com.peter.main.concurrency;

/**
 * Copyright (C), Peter GUAN
 * FileName: BuyTicketUnsafe
 * Author:   Peter
 * Date:     02/03/2022 10:08
 * Description: 不安全买票， 即会出现资源争抢. 线程不安全 有负数， 或者拿到同一张票
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