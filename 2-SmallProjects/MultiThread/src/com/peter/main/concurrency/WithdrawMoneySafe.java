package com.peter.main.concurrency;

/**
 * Copyright (C), Peter GUAN
 * FileName: WithdrawMoneySafe
 * Author:   Peter
 * Date:     02/03/2022 10:53
 * Description: 使用synchronized方法锁住object
 * History:
 * Version:
 */
public class WithdrawMoneySafe {

    public static void main(String[] args) {
        Account1 account = new Account1(100, "John");
        WithdrawMoney1 husband = new WithdrawMoney1(account, 50, "husband");
        WithdrawMoney1 wife = new WithdrawMoney1(account, 100, "wife");

        husband.start();
        wife.start();
    }
}


class Account1 {

    private int balance;
    private String name;

    public Account1(int balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class WithdrawMoney1 extends Thread {
    /**
     * 不涉及多个线程操作同一个object
     */

    private Account1 account;
    private int withdrawMoney;
    private int balanceInPerson;

    public WithdrawMoney1(Account1 account, int withdrawMoney, String name) {
        super(name);
        this.account = account;
        this.withdrawMoney = withdrawMoney;
    }

    @Override
    public void run() {

//        while (true) {
        // 锁的随想涉及到增删改
        synchronized (account) {
            if (account.getBalance() - withdrawMoney < 0) {
                System.out.println(this.getName() + " No money!");
                return;
            } else {
                // 卡内余额
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(account.getName() + " balance " + account.getBalance());

                account.setBalance(account.getBalance() - withdrawMoney);
                // 手里的钱
                balanceInPerson += withdrawMoney;

                System.out.println(this.getName() + " balance in person: " + balanceInPerson);

            }
        }

//        }
    }
}
