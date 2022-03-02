package com.peter.main.concurrency;

/**
 * Copyright (C), Peter GUAN
 * FileName: BuyTicketSafe
 * Author:   Peter
 * Date:     02/03/2022 10:44
 * Description: 使用synchronized 同步方法锁定代码块
 * History:
 * Version:
 */
public class BuyTicketSafe {
    public static void main(String[] args) {
        BuyTicket1 buyTicket = new BuyTicket1();
        new Thread(buyTicket).start();
        new Thread(buyTicket).start();
        new Thread(buyTicket).start();

    }
}

class BuyTicket1 implements Runnable {

    private int ticketNum = 10;
    private boolean flag = true; // 外部停止方法

    @Override
    public void run() {
        //  but ticket
        while (flag) {
            buy();
        }
    }

    private synchronized void buy() {
        if (ticketNum <= 0) {
            flag = false;
            return;
        }

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " get ticket No " + ticketNum--);
    }
}