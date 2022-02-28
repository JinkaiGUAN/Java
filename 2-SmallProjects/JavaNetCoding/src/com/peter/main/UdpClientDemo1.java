package com.peter.main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * Copyright (C), Peter GUAN
 * FileName: UdpClientDemo1
 * Author:   Peter
 * Date:     28/02/2022 08:25
 * Description:
 * History:
 * Version:
 */
public class UdpClientDemo1 {
    public static void main(String[] args) throws Exception {
        // 建立一个socket
        DatagramSocket socket = new DatagramSocket();

        // 建立一个包
        String msg = "Hello world!";
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9090;

        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);

        // 发送包
        socket.send(packet);

        // close stream
        socket.close();
    }
}
