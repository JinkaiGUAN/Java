package com.peter.dao;

import com.peter.pojo.Teacher;

import java.util.List;

/**
 * Copyright (C), Peter GUAN
 * FileName: TeacherMappper
 * Author:   Peter
 * Date:     22/04/2022 18:00
 * Description:
 * History:
 * Version:
 */
public interface TeacherMapper {

    List<Teacher> selectTeachers();
}
