package spring01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import spring01.dao.AlphaDao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Copyright (C), Peter GUAN
 * FileName: AlphaService
 * Author:   Peter
 * Date:     08/03/2022 18:23
 * Description:
 * History:
 * Version:
 */

@Service // 业务组件
//@Scope("prototype")  // 可实例化多个对象， 但是通常我们只是用单一对象
public class AlphaService {

    @Autowired
    private AlphaDao alphaDao;

    public AlphaService() {
        System.out.println("Construct --- AlphaService");
    }

    @PostConstruct // 再构造器之后调用
    public void init() {
        System.out.println("Initialize the AlphaService!");
    }

    @PreDestroy // 销毁对象之前调用
    public void destroy() {

    }

    public String find() {
        return alphaDao.select();
    }
}
