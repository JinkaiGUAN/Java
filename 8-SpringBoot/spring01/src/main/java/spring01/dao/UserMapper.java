package spring01.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import spring01.entity.User;


/**
 * Copyright (C), Peter GUAN
 * FileName: UserMapper
 * Author:   Peter
 * Date:     09/03/2022 01:00
 * Description:
 * History:
 * Version:
 */

//@Mapper // 无法使用

//@Repository
@Mapper // mybatis 数据访问组件
public interface UserMapper {
    User selectByID(int id);

    User selectByName(String username);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id, int status);

    int updateHeader(int id, String headerUrl);

    int updatePassword(int id, String password);

}


