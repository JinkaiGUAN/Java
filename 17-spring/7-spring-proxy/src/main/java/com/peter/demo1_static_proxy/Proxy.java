package com.peter.demo1_static_proxy;

/**
 * Copyright (C), Peter GUAN
 * FileName: Proxy
 * Author:   Peter
 * Date:     03/05/2022 08:24
 * Description:
 * History:
 * Version:
 */
public class Proxy implements Rent{

    private Host host;

    public Proxy() {

    }

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        checkHouse();
        host.rent();
        fare();
    }

    public void checkHouse() {
        System.out.println("带房客看房！");
    }

    public void fare() {
        System.out.println("收中介费！");
    }
}
