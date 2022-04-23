package com.peter.entity;

/**
 * Copyright (C), Peter GUAN
 * FileName: SimplePizzaFactory
 * Author:   Peter
 * Date:     23/04/2022 11:30
 * Description:
 * History:
 * Version:
 */
public class SimplePizzaFactory {

    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        }

        return pizza;
    }
}
