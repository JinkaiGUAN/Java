package com.peter.dao;

import com.peter.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    @Select("select * from teacher where id=#{id}")
    Teacher selectTeacherById(@Param("id") int id);
}
