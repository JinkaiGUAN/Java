package javaLearning.multiprocessLearning;

import java.util.concurrent.*;

/**
 * Copyright (C), Peter GUAN
 * FileName: T02_FutureTask
 * Author:   Peter
 * Date:     08/04/2022 08:54
 * Description:
 * History:
 * Version:
 */
public class T02_FutureTask {

    public static final int MAX_TURN = 5;
    public static final int COMPUTE_TIMES = 1000000;

    /**
     * 创建一个Callable接口实现类
     */
    static class ReturnableTask implements Callable<Long> {

        /**
         * 编写异步执行的具体逻辑， 可以携带返回值
         * @return
         * @throws Exception
         */
        @Override
        public Long call() throws Exception {
            long startTime = System.currentTimeMillis();
            System.out.println(Print.getCurrentThreadName() + " 线程开始运行！");
            Thread.sleep(1000);

            for (int i = 0; i < COMPUTE_TIMES; i++) {
                int j =i * 1000;
            }
            long used = System.currentTimeMillis() - startTime;
            System.out.println(Print.getCurrentThreadName() + " 线程结束！");
            return used;
        }
    }

    public static void main(String args[]) throws InterruptedException {
        ReturnableTask task = new ReturnableTask();
        FutureTask<Long> futureTask = new FutureTask<>(task);
        Thread thread = new Thread(futureTask, task.getClass().getName());
        thread.start();
        Thread.sleep(500);
        System.out.println(Print.getCurrentThreadName() + " 让子弹飞一会.");
        System.out.println(Print.getCurrentThreadName() + " 做一点自己的事情。");
        for (int i = 0; i < COMPUTE_TIMES / 2; i++) {
            int j = i * 1000;
        }

        System.out.println(Print.getCurrentThreadName() + " 获取结果。");
        try {
            System.out.println(Print.getCurrentThreadName() + " 线程占用时间 " + futureTask.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(Print.getCurrentThreadName() + " 运行结束！");

        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("Runnable!");
                }
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("Runnable!");
                }
            }
        });

        pool.submit(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return null;
            }
        });

    }
}

class Print {

    public static String getCurrentThreadName() {
        Thread thread = Thread.currentThread();
        return thread.getName();
    }
}