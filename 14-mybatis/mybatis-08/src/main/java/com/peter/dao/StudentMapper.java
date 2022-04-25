package com.peter.dao;


import com.peter.pojo.Student;
import org.apache.ibatis.annotations.Param;

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

    Student selectStudentById(@Param("id") int id);
}
