package com.peter.pojo;

/**
 * Copyright (C), Peter GUAN
 * FileName: Address
 * Author:   Peter
 * Date:     29/04/2022 08:42
 * Description:
 * History:
 * Version:
 */
public class Address {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }
}
