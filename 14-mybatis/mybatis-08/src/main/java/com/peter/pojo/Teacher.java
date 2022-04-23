package com.peter.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Copyright (C), Peter GUAN
 * FileName: Teacher
 * Author:   Peter
 * Date:     22/04/2022 17:57
 * Description:
 * History:
 * Version:
 */
@Data
@ToString
public class Teacher {

    private int id;
    private String name;
    private List<Student> students;

}
