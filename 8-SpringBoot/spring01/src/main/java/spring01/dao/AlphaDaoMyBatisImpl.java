package spring01.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * Copyright (C), Peter GUAN
 * FileName: AlphaDaoMyBatisImpl
 * Author:   Peter
 * Date:     08/03/2022 18:07
 * Description:
 * History:
 * Version:
 */

@Repository
@Primary
public class AlphaDaoMyBatisImpl implements AlphaDao{
    @Override
    public String select() {
        return "MyBatis";
    }
}
