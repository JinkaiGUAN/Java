package com.peter.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * Copyright (C), Peter GUAN
 * FileName: Blog
 * Author:   Peter
 * Date:     26/04/2022 08:10
 * Description:
 * History:
 * Version:
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;
}
