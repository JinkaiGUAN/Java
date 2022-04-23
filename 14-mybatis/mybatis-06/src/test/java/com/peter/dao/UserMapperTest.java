package com.peter.dao;

import com.peter.pojo.Student;
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
    public void testSelectStudents() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testSelectStudents2() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectStudents2();
        for (Student student : students) {
            System.out.println(student);
        }
    }

}
