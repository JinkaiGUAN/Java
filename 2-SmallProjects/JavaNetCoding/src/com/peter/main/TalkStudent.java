package com.peter.main;

/**
 * Copyright (C), Peter GUAN
 * FileName: TalkStudent
 * Author:   Peter
 * Date:     28/02/2022 09:25
 * Description:
 * History:
 * Version:
 */
public class TalkStudent {

    public static void main(String[] args) {
        new Thread(new TalkSend(7777, "localhost", 9999)).start();
        new Thread(new TalkReceive(8888, "Lecturer")).start();
    }
}
