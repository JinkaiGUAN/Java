package com.peter.main;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Copyright (C), Peter GUAN
 * FileName: TcpServerDemo2
 * Author:   Peter
 * Date:     27/02/2022 14:39
 * Description:
 * History:
 * Version:
 */

public class TcpServerDemo2 {
    public static void main(String[] args) {
        // 创建一个服务端口
        ServerSocket serverSocket = null;
        // 接受服务套接字
        Socket accept = null;
        // 接受文件
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream os = null;
        try{
            serverSocket = new ServerSocket(9000);

            // fixme: 为什么用while不会返回结束信息？
            accept = serverSocket.accept();
            is = accept.getInputStream();

            fos = new FileOutputStream(new File("receive.jpg"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            // 通知客户端 文件已接受
            os = accept.getOutputStream();
            os.write("The file has been accepted!".getBytes());


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
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
