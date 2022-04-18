package spring01;

import java.io.IOException;

/**
 * Copyright (C), Peter GUAN
 * FileName: wkTests
 * Author:   Peter
 * Date:     05/04/2022 14:25
 * Description:
 * History:
 * Version:
 */

public class wkTests {

    public static void main(String[] args) {
        //String cmd = "D:\\SoftwareAPPs\\Java\\wkhtmltopdf\\installer\\wkhtmltopdf\\bin\\wkhtmltoimage --quality 75 " +
        //        "https://scikit-learn.org/stable/modules/generated/sklearn.metrics.accuracy_score.html E:\\SoftwareDevelopmentJava\\8" +
        //        "-SpringBoot\\data\\wk_images\\1.png";

        String cmd = "D:/SoftwareAPPs/Java/wkhtmltopdf/installer/wkhtmltopdf/bin/wkhtmltoimage --quality 75 " +
                "https://scikit-learn.org/stable/modules/generated/sklearn.metrics.accuracy_score.html " +
                "E:/SoftwareDevelopmentJava/8-SpringBoot/data/wk_images/00ab8b99_7dca_45f7_a3cc_749cd3466406.png";
        try {
            Runtime.getRuntime().exec(cmd);
            System.out.println("ok");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
