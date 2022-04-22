import com.peter.dao.UserMapper;
import com.peter.pojo.User;
import com.peter.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Copyright (C), Peter GUAN
 * FileName: MyBatisTest
 * Author:   Peter
 * Date:     19/04/2022 22:36
 * Description:
 * History:
 * Version:
 */
public class MyBatisTest {

    @Test
    public void testSession() {
        SqlSession session = MyBatisUtil.getSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.getUserList();

        for (User user : users) {
            System.out.println(user);
        }

        session.close();
    }
}
