import com.peter.dao.TeacherMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import com.peter.pojo.Teacher;
import com.peter.util.MyBatisUtil;

import java.util.List;

/**
 * Copyright (C), Peter GUAN
 * FileName: UserMapperTest
 * Author:   Peter
 * Date:     19/04/2022 20:14
 * Description:
 * History:
 * Version:
 */
public class UserMapperTest {
    private static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void testSelectStudents() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.selectTeachers();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }

    }



}
