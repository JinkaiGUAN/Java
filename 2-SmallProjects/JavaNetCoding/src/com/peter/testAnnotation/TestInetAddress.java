package com.peter.testAnnotation;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Copyright (C), Peter GUAN
 * FileName: TestInetAddress
 * Author:   Peter
 * Date:     27/02/2022 09:51
 * Description:
 * History:
 * Version:
 */
public class TestInetAddress {

    /**
     * 确定InetAddress的域名或者ip
     * @param args
     */
    public static void main(String[] args) {
        try {
            // get the ip of local host
            InetAddress inetAddress1 = InetAddress.getByName("127.0.01");
            System.out.println(inetAddress1);

            // get the ip of the corresponding website
            InetAddress inetAddress2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress2);

            // methods
            System.out.println(Arrays.toString(inetAddress2.getAddress()));
            System.out.println(inetAddress2.getCanonicalHostName());
            System.out.println(inetAddress2.getHostAddress()); // ip
            System.out.println(inetAddress2.getHostName());  // 域名或者本机地址

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
