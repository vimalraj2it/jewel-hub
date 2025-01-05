package org.jewel.hub.common.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories(basePackages = "org.jewel.hub")
@ImportResource("classpath:applicationContext-resource.xml")
public class commonConfig {

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27017");
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "jewel-hub");
    }

    @Bean
    public MongoTransactionManager transactionManager(MongoClient mongoClient) {
        return new MongoTransactionManager(mongoTemplate().getMongoDatabaseFactory());
    }
}


