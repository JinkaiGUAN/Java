package com.peter.demo1_static_proxy;

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

        Proxy proxy = new Proxy(host);
        proxy.rent();
    }
}
