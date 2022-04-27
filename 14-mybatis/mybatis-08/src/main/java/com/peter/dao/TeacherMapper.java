package com.peter.dao;

import com.peter.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 获取指定老师下的所有学生及老师信息
     */
    Teacher selectTeacherById(@Param("id") int id);


    Teacher selectTeacherById2(@Param("id") int id);

}
