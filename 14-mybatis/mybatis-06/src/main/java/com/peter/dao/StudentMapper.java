package com.peter.dao;

import com.peter.pojo.Student;

import java.util.List;

/**
 * Copyright (C), Peter GUAN
 * FileName: StudentMapper
 * Author:   Peter
 * Date:     22/04/2022 17:59
 * Description:
 * History:
 * Version:
 */
public interface StudentMapper {

    List<Student> selectStudents();

    List<Student> selectStudents2();

}
