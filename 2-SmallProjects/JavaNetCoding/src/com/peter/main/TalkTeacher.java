package com.peter.main;

/**
 * Copyright (C), Peter GUAN
 * FileName: TalkTeacher
 * Author:   Peter
 * Date:     28/02/2022 09:26
 * Description:
 * History:
 * Version:
 */
public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkSend(5555, "localhost", 8888)).start();
        new Thread(new TalkReceive(9999, "Student")).start();
    }

}
