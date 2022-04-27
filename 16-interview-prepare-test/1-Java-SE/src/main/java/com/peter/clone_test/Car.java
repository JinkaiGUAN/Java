package com.peter.clone_test;

import java.io.Serializable;

/**
 * Copyright (C), Peter GUAN
 * FileName: Car
 * Author:   Peter
 * Date:     27/04/2022 11:25
 * Description:
 * History:
 * Version:
 */
public class Car implements Serializable {
    private static final long serialVersionUID = -5713945027627603702L;

    private String brand;
    private int maxSpeed;

    public Car(String brand, int maxSpeed) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
