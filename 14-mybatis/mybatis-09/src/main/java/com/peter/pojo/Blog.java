package com.peter.pojo;

import lombok.Data;
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
public class Blog {

    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;
}
