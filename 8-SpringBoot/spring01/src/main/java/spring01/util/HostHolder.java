package spring01.util;

import org.springframework.stereotype.Component;
import spring01.entity.User;

/**
 * Copyright (C), Peter GUAN
 * FileName: HostHolder
 * Author:   Peter
 * Date:     15/03/2022 20:42
 * Description:
 * History:
 * Version:
 */

/**
 * 持有用户信息， 用于代替session对象。
 */
@Component
public class HostHolder {

    private ThreadLocal<User> users = new ThreadLocal<User>();

    public void setUser(User user) {
        users.set(user);
    }

    public User getUser() {
        return users.get();
    }

    public void clear() {
        users.remove();
    }
}
