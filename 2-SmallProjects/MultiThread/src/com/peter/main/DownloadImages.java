package com.peter.main;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * Copyright (C), Peter GUAN
 * FileName: DownloadImages
 * Author:   Peter
 * Date:     28/02/2022 23:55
 * Description:
 * History:
 * Version:
 */
public class DownloadImages implements Callable<Boolean> {

    private String url;
    private String name;

    public DownloadImages(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(this.url, this.name);

        System.out.println("Downloaded " + this.name);

        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        DownloadImages t1 = new DownloadImages("https://resources.jetbrains.com/help/img/idea/2021" +
                ".3/change-lib-level.png", "1.png");
        DownloadImages t2 = new DownloadImages("https://resources.jetbrains.com/help/img/idea/2021" +
                ".3/change-lib-level.png", "2.png");
        DownloadImages t3 = new DownloadImages("https://resources.jetbrains.com/help/img/idea/2021" +
                ".3/change-lib-level.png", "3.png");

        // 创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        // 提交执行
        Future<Boolean> res1 = ser.submit(t1);
        Future<Boolean> res2 = ser.submit(t2);
        Future<Boolean> res3 = ser.submit(t3);

        // 获取结果
        boolean rs1 = res1.get();
        boolean rs2 = res2.get();
        boolean rs3 = res3.get();

        // 关闭服务
        ser.shutdownNow();
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
