package com.peter.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Copyright (C), Peter GUAN
 * FileName: UdpSenderDemo1
 * Author:   Peter
 * Date:     28/02/2022 08:43
 * Description:
 * History:
 * Version:
 */
public class UdpSenderDemo1 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8888);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String msg = reader.readLine();
            byte[] sendData = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(sendData, 0, sendData.length,
                    new InetSocketAddress("localhost", 9090));
            socket.send(packet);

            if (msg.equals("bye")) {
                break;
            }
        }

        socket.close();
    }
}
