package com.peter.main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Copyright (C), Peter GUAN
 * FileName: UdpReceiveDemo1
 * Author:   Peter
 * Date:     28/02/2022 08:44
 * Description:
 * History:
 * Version:
 */
public class UdpReceiveDemo1 {

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(9090);

        while (true) {
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
            socket.receive(packet);

            String receiveData = new String(packet.getData());
            System.out.println(receiveData);
            if (receiveData.equals("bye")) {
                break;
            }
        }

        socket.close();
    }
}
