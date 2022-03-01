package com.peter.test;

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