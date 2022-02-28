package com.peter.main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Copyright (C), Peter GUAN
 * FileName: TalkReceive
 * Author:   Peter
 * Date:     28/02/2022 09:11
 * Description:
 * History:
 * Version:
 */
public class TalkReceive implements Runnable {
    DatagramSocket socket = null;

    private int port;
    private String msgFrom;

    public TalkReceive(int port, String msgFrom) {
        this.port = port;
        this.msgFrom = msgFrom;

        try {
            this.socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {

        while (true) {
            try {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
                socket.receive(packet);
                String receiveData = new String(packet.getData());
                System.out.println("Receive data from " + this.msgFrom + " " + packet.getAddress() + " --- " + receiveData);
                if (receiveData.equals("bye")) {
                    break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        socket.close();
    }
}
