package com.mick.mmg;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Context;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Primary;
import org.testcontainers.containers.GenericContainer;

import javax.inject.Singleton;

@Factory
public class TestBeanFactory {
    @SuppressWarnings("rawtypes")
    @Context
    @Bean
    @Singleton
    @Primary
    public MongoDatabase mongoDatabase(){
        GenericContainer genericContainer = new GenericContainer<>("mongo:4.2");
        genericContainer.addExposedPort(27017);
        genericContainer.start();

        Integer mongoPort = genericContainer.getMappedPort(27017);

        MongoClient mongoClient = MongoClients.create(String.format("mongodb://localhost:%s/local", mongoPort));
        return mongoClient.getDatabase("mmg-test");
    }
}
