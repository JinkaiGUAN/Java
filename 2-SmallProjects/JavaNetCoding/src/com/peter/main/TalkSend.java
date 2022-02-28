package com.peter.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * Copyright (C), Peter GUAN
 * FileName: TalkSend
 * Author:   Peter
 * Date:     28/02/2022 09:11
 * Description:
 * History:
 * Version:
 */
public class TalkSend implements Runnable {
    DatagramSocket socket = null;
    BufferedReader reader = null;

    private int fromPort;
    private String toIp;
    private int toPort;

    public TalkSend(int fromPort, String toIp, int toPort) {
        this.fromPort = fromPort;
        this.toIp = toIp;
        this.toPort = toPort;

        try {
            this.socket = new DatagramSocket(fromPort);
            this.reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        while (true) {
            String msg = null;
            try {
                msg = this.reader.readLine();
                byte[] sendData = msg.getBytes();
                DatagramPacket packet = new DatagramPacket(sendData, 0, sendData.length,
                        new InetSocketAddress(toIp, toPort));
                socket.send(packet);

                if (msg.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        socket.close();
    }
}
