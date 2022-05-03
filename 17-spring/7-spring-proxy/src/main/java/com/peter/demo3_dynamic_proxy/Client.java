package com.peter.demo3_dynamic_proxy;

/**
 * Copyright (C), Peter GUAN
 * FileName: Client
 * Author:   Peter
 * Date:     03/05/2022 08:27
 * Description:
 * History:
 * Version:
 */
public class Client {
    public static void main(String[] args) {
        Host host = new Host();

        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setRent(host);

        Rent proxy = (Rent) pih.getProxy();
        proxy.rent();

    }
}
