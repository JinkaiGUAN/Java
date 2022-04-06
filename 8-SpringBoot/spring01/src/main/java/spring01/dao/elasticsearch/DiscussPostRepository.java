package spring01.dao.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import spring01.entity.DiscussPost;

/**
 * Copyright (C), Peter GUAN
 * FileName: DiscussPostRepository
 * @Author:  Peter
 * Date:     31/03/2022 19:52
 * Description:
 * History:
 * Version:
 */
//@Mapper 是mybatis专用与数据库接口
@Repository
public interface DiscussPostRepository extends ElasticsearchRepository<DiscussPost, Integer> {
    // 继承ElasticsearchRepository， 要说明拓展接口的实体和其主键

}
