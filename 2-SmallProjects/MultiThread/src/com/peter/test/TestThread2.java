package com.peter.test;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Copyright (C), Peter GUAN
 * FileName: TestThread2
 * Author:   Peter
 * Date:     28/02/2022 22:51
 * Description: Using multi-thread to implement a image downloader
 * History:
 * Version:
 */
public class TestThread2 extends Thread {

    private String url;
    private String name;

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(this.url, this.name);

        System.out.println("Downloaded " + this.name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://resources.jetbrains.com/help/img/idea/2021" +
                ".3/change-lib-level.png", "1.png");
        TestThread2 t2 = new TestThread2("https://resources.jetbrains.com/help/img/idea/2021" +
                ".3/change-lib-level.png", "2.png");
        TestThread2 t3 = new TestThread2("https://resources.jetbrains.com/help/img/idea/2021" +
                ".3/change-lib-level.png", "3.png");
        t1.start();
        t2.start();
        t3.start();
    }
}

class WebDownloader {

    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO exception in downloader!");
        }
    }
}

