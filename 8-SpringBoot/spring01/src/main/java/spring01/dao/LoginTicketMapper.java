package spring01.dao;

import org.apache.ibatis.annotations.*;
import spring01.entity.LoginTicket;

/**
 * Copyright (C), Peter GUAN
 * FileName: LoginTicketMapper
 * Author:   Peter
 * Date:     14/03/2022 11:35
 * Description:
 * History:
 * Version:
 */

@Mapper
@Deprecated
public interface LoginTicketMapper {

    @Insert({
            "insert into login_ticket(user_id, ticket, status, expired) ",
            "values(#{userId}, #{ticket}, #{status}, #{expired})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id") // 自动生成 主键
    int insertLoginTicket(LoginTicket loginTicket);

    // 本表是以ticket为唯一标识进行查询访问
    @Select({
            "select id, user_id, ticket, status, expired from login_ticket where ticket=#{ticket}"
    })
    LoginTicket selectByTicket(String ticket);

    // 通过修改用户状态 判断是否 在线
    @Update({
            "update login_ticket set status=#{status} where ticket=#{ticket}"
    })
    int updateStatus(String ticket, int status);
}
