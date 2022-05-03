package com.peter.demo1_static_proxy;

/**
 * Copyright (C), Peter GUAN
 * FileName: Host
 * Author:   Peter
 * Date:     03/05/2022 08:23
 * Description:
 * History:
 * Version:
 */
public class Host implements Rent{
    @Override
    public void rent() {
        System.out.println("房屋出租！");
    }
}
