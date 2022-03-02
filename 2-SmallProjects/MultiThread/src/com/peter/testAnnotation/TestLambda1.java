package com.peter.testAnnotation;

/**
 * Copyright (C), Peter GUAN
 * FileName: TestLambda1
 * Author:   Peter
 * Date:     01/03/2022 08:49
 * Description:
 * History:
 * Version:
 */
public class TestLambda1 {

    // 静态内部类
    static class Like2 implements ILike {

        @Override
        public void lambda() {
            System.out.println("I like lambda");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        //静态内部类
        ILike like2 = new Like2();
        like.lambda();

        // 局部内部类
        class Like3 implements ILike {

            @Override
            public void lambda() {
                System.out.println("I like lambda");
            }
        }

        ILike like3 = new Like3();
        like3.lambda();

        // 匿名内部类
        ILike like4 = new ILike() {

            @Override
            public void lambda() {
                System.out.println("I love lambda!");
            }
        };
        like4.lambda();

        // lambda 简化
        ILike like5 = () -> System.out.println("I love lambda!");
        like5.lambda();


    }

}

interface ILike {
    public abstract void lambda();
}

class Like implements ILike {

    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}
