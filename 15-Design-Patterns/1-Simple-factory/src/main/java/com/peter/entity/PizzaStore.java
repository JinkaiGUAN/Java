package com.peter.entity;

/**
 * Copyright (C), Peter GUAN
 * FileName: PizzaStore
 * Author:   Peter
 * Date:     23/04/2022 11:35
 * Description:
 * History:
 * Version:
 */
public class PizzaStore {
    private SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = factory.createPizza(type);

        return pizza;
    }
}
