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
 * Date:     19/04/2022 19:35
 * Description:
 * History:
 * Version:
 * @author Peter
 */
public class MyBatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

    // 为类初始化准备， 类一加载就就开始初始化
    static {
        try {
            // 获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。
     * 你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
     * @return
     */
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession(true);
    }

}
