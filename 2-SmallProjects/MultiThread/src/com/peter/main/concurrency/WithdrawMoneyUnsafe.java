package com.peter.main.concurrency;

/**
 * Copyright (C), Peter GUAN
 * FileName: WithdrawMoneyUnsafe
 * Author:   Peter
 * Date:     02/03/2022 10:17几个人同时在一个账户中发生交易
 * History:
 * Version:
 */
public class WithdrawMoneyUnsafe {
    public static void main(String[] args) {
        Account account = new Account(100, "John");
        WithdrawMoney husband = new WithdrawMoney(account, 50, "husband");
        WithdrawMoney wife = new WithdrawMoney(account, 100, "wife");

        husband.start();
        wife.start();
    }
}


class Account {

    private int balance;
    private String name;

    public Account(int balance, String name) {
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

class WithdrawMoney extends Thread {
    /**
     * 不涉及多个线程操作同一个object
     */

    private Account account;
    private int withdrawMoney;
    private int balanceInPerson;

    public WithdrawMoney(Account account, int withdrawMoney, String name) {
        super(name);
        this.account = account;
        this.withdrawMoney = withdrawMoney;
    }

    @Override
    public void run() {

//        while (true) {
            if (account.getBalance() < 0) {
                System.out.println(this.getName() + " No money!");
                return;
            } else {
                // 卡内余额
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                account.setBalance(account.getBalance() - withdrawMoney);
                // 手里的钱
                balanceInPerson += withdrawMoney;
                System.out.println(account.getName() + " balance " + account.getBalance());
                System.out.println(this.getName() + " balance in person: " + balanceInPerson);
            }
//        }
    }
}

