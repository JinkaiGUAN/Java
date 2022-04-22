package com.peter.pojo;

import lombok.*;

/**
 * Copyright (C), Peter GUAN
 * FileName: User
 * Author:   Peter
 * Date:     19/04/2022 19:54
 * Description:
 * History:
 * Version:
 * @author Peter
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {

    private int id;
    private String name;
    private String password;
}
