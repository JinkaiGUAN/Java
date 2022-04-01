package spring01.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;

/**
 * Copyright (C), Peter GUAN
 * FileName: ElasticSearchConfig
 *
 * @Author: Peter
 * Date:        01/04/2022 09:28
 * Description: elasticsearch configuration
 * History:
 * Version:
 */

@Configuration
public class ElasticSearchConfig {
    /**
     * elasticsearch地址
     */
    @Value("${elasticSearch.url}")
    private String esUrl;

    /**
     * localhost:9200 写在配置文件中就可以了
     *
     * @return
     */
    @Bean
    RestHighLevelClient client() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(esUrl)
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
