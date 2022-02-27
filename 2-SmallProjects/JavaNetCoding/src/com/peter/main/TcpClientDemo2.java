package com.peter.main;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Copyright (C), Peter GUAN
 * FileName: TcpClientDemo2
 * Author:   Peter
 * Date:     27/02/2022 14:25
 * Description:
 * History:
 * Version:
 */
public class TcpClientDemo2 {

    public static void main(String[] args) {

        Socket  socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            // 创建一个socket 链接
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
            // 创建一个输出流
            os = socket.getOutputStream();

            fis = new FileInputStream(new File("demo2.jpg"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }

            // 通知服务器 我已经结束了
            socket.shutdownOutput();

            // 接收信息
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] buffer2 = new byte[1024];
            int len2;
            while ((len2 = is.read(buffer2)) != -1) {
                baos.write(buffer2, 0, len2);
            }
            System.out.println(baos.toString());


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch(Exception e) {
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
