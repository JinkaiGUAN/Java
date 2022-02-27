package com.peter.main;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Copyright (C), Peter GUAN
 * FileName: TcpServerDemo1
 * Author:   Peter
 * Date:     27/02/2022 10:39
 * Description:
 * History:
 * Version:
 */
public class TcpServerDemo1 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
            // 1. 我有一个地址
            serverSocket = new ServerSocket(9999);
            while (true) {
                // 2. 等待客户端链接
                accept = serverSocket.accept();
                // 3. 读取客户端消息
                is = accept.getInputStream();
                // 管道流
                baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }
                System.out.println(baos.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源 - 先开后关
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
