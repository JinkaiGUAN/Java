package com.peter.testAnnotation;

/**
 * Copyright (C), Peter GUAN
 * FileName: TestLambda2
 * Author:   Peter
 * Date:     01/03/2022 09:12
 * Description:
 * History:
 * Version:
 */
public class TestLambda2 {

    static class Love2 implements ILove {

        @Override
        public void love(int a) {
            System.out.println("I love " + a);
        }
    }

    public static void main(String[] args) {
        ILove love = new Love();
        love.love(1);

        // 静态内部类
        love = new Love2();
        love.love(2);

        // 局部内部类
        class Love3 implements ILove {

            @Override
            public void love(int a) {
                System.out.println("I love " + a);
            }
        }

        love = new Love3();
        love.love(3);

        // 匿名内部类
        love = new ILove() {
            @Override
            public void love(int a) {
                System.out.println("I love " + a);
            }
        };
        love.love(4);

        // lambda函数
        love = (a) -> System.out.println("I love " + a);
        love.love(5);

        /**
         * Note
         * 1。实现函数的代码只有一行时， 可以删除代码体的花括号去掉。
         * 2. 前提接口是函数式接口（接口只有一个方法）
         * 3. 多个参数也可以参数类型， 如果去掉一个参数类型， 其他的也要去掉， 必须加上括号 （参数大于等于2时）。
         */
    }
}


interface ILove {
    public abstract void love(int a);
}

class Love implements ILove {

    @Override
    public void love(int a) {
        System.out.println("I love " + a);
    }
}