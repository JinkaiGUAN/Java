package com.peter.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Copyright (C), Peter GUAN
 * FileName: MyBatisUtil
 * Author:   Peter
 * Date:     19/04/2022 22:29
 * Description:
 * History:
 * Version:
 * @author Peter
 */
public class MyBatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        InputStream inputStream = null;
        try {
            String resource = "mybatis-config.xml";
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }

}
