package com.peter.test;

import java.net.InetSocketAddress;

/**
 * Copyright (C), Peter GUAN
 * FileName: TestInetSocketAddress
 * Author:   Peter
 * Date:     27/02/2022 10:20
 * Description:
 * History:
 * Version:
 */
public class TestInetSocketAddress {
    public static void main(String[] args) {

        InetSocketAddress socketAddress = new InetSocketAddress("127.0.01", 8080);
        System.out.println(socketAddress);

        InetSocketAddress socketAddress1 = new InetSocketAddress("localhost", 8080);
        System.out.println(socketAddress1);

        System.out.println(socketAddress.getAddress());
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress.getPort());

    }
}
