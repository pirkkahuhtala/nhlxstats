package com.mediatuotantoph.nhlxstats.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

/**
 * Configuration for MongoDB
 * 
 * @author Pirkka Huhtala
 *
 */
@EnableMongoRepositories("com.mediatuotantoph.nhlxstats")
public class Mongo {

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(new MongoClient("localhost"), "nhlxstats");
    }

}