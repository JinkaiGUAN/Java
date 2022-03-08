package spring01.dao;

import org.springframework.stereotype.Repository;

/**
 * Copyright (C), Peter GUAN
 * FileName: AlphaDaoHibernateImpl
 * Author:   Peter
 * Date:     08/03/2022 18:04
 * Description:
 * History:
 * Version:
 */

@Repository
public class AlphaDaoHibernateImpl implements AlphaDao {

    @Override
    public String select() {
        return "Hibernate";
    }
}
