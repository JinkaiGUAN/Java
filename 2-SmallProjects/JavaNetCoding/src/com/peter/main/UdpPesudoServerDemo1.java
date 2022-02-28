package com.peter.main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Copyright (C), Peter GUAN
 * FileName: UdpPesudoServerDemo1
 * Author:   Peter
 * Date:     28/02/2022 08:36
 * Description:
 * History:
 * Version:
 */
public class UdpPesudoServerDemo1 {
    public static void main(String[] args) throws Exception {
        // 开放端口
        DatagramSocket socket = new DatagramSocket(9090);
        // 数据容器
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        // 接收数据
        socket.receive(packet);

        socket.close();

        System.out.println(new String(packet.getData()));
    }
}
