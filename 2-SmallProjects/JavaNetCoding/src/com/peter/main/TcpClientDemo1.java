package com.peter.main;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Copyright (C), Peter GUAN
 * FileName: TcpClientDemo1
 * Author:   Peter
 * Date:     27/02/2022 10:39
 * Description:
 * History:
 * Version:
 */
public class TcpClientDemo1 {

    public static void main(String[] args) {

        Socket socket = null;
        // 4. 发送消息
        OutputStream os = null;

        try {
            // 1. 知道服务器的地址
            InetAddress serverIp = InetAddress.getByName("127.0.0.1");
            // port number
            int port = 9999;
            // 2. 创建一个socket 链接
            socket = new Socket(serverIp, port);
            // 4. 发送消息
            os = socket.getOutputStream();
            os.write("Hello world".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
