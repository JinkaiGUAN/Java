package com.peter.entity;

/**
 * Copyright (C), Peter GUAN
 * FileName: CheesePizza
 * Author:   Peter
 * Date:     23/04/2022 11:33
 * Description:
 * History:
 * Version:
 */
public class CheesePizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("prepare the cheese pizza ....");
    }

    @Override
    public void bake() {
        System.out.println("bake the cheese pizza ...");
    }

    @Override
    public void cut() {
        System.out.println("cut the cheese pizza ...");
    }

    @Override
    public void box() {
        System.out.println("box the cheese pizza ...");
    }
}
