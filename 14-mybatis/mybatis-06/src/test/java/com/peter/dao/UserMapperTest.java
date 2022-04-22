package com.peter.dao;

import com.peter.pojo.Teacher;
import com.peter.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), Peter GUAN
 * FileName: UserMapperTest
 * Author:   Peter
 * Date:     19/04/2022 20:14
 * Description:
 * History:
 * Version:
 */
public class UserMapperTest {
    private static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void testSelectTeacherById() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.selectTeacherById(1);
        System.out.println(teacher);
    }

}
