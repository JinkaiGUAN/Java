package com.peter.io;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * Copyright (C), Peter GUAN
 * FileName: InputStreamTest
 * Author:   Peter
 * Date:     02/05/2022 16:54
 * Description:
 * History:
 * Version:
 */
public class InputStreamTest {

    @Test
    public void testFileInputStream() throws IOException {
        FileInputStream fis = new FileInputStream(new File("E:\\SoftwareDevelopmentJava\\16-interview-prepare-test\\1" +
                "-Java-SE\\src\\main\\resources\\test.txt"));
        int by;
        // 一次读取一个字节
        while ((by=fis.read()) != -1) {
            //因为字符在底层存储的时候就是存储的数值。即字符对应的ASCII码。
            //所以需要强制转换一下类型
            System.out.print((char) by);
        }

        fis.close();
    }

    @Test
    public void testFileInputStream2() throws IOException {
        FileInputStream fis = new FileInputStream(new File("E:\\SoftwareDevelopmentJava\\16-interview-prepare-test\\1" +
                "-Java-SE\\src\\main\\resources\\test.txt"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len=fis.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, len));
        }

        fis.close();
    }

    //@Test
    public static void testFileOutputStream() throws IOException {
        FileOutputStream fos = new FileOutputStream(new File("E:\\SoftwareDevelopmentJava\\16-interview-prepare-test" +
                "\\1-Java-SE\\src\\main\\resources\\test1.txt"));

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            //会发现输入65 66 67数字变成了字符ABC，因为字符在底层存储的时候就是存储的数值。即字符对应的ASCII码。
            int a = scanner.nextInt();
            fos.write(a);
        }

        scanner.close();
        fos.close();

    }

    public static void main(String[] args) throws IOException {
        testFileOutputStream();
    }

}
