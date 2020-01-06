package com.mick.mmg.db;


import com.mick.mmg.game.entity.GameRepository;
import com.mick.mmg.round.entity.RoundRepository;
import com.mick.mmg.songs.service.SongRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Context;
import io.micronaut.context.annotation.Factory;
import org.bson.Document;

import javax.inject.Named;
import javax.inject.Singleton;

@Factory
public class DatabaseFactory {
    @Bean
    @Singleton
    @Named(GameRepository.COLLECTION_NAME)
    public MongoCollection<Document> provideGameCollection(MongoDatabase mongoDatabase) {
        return mongoDatabase.getCollection(GameRepository.COLLECTION_NAME);
    }

    @Bean
    @Singleton
    @Named(RoundRepository.COLLECTION_NAME)
    public MongoCollection<Document> provideRoundCollection(MongoDatabase mongoDatabase) {
        return mongoDatabase.getCollection(RoundRepository.COLLECTION_NAME);
    }

    @Bean
    @Singleton
    @Named(SongRepository.COLLECTION_NAME)
    public MongoCollection<Document> provideSongCollection(MongoDatabase mongoDatabase) {
        return mongoDatabase.getCollection(SongRepository.COLLECTION_NAME);
    }

    @Context
    @Bean
    @Singleton
    public MongoDatabase provideMongoClient(DatabaseConfig databaseConfig){
        MongoClient mongoClient = MongoClients.create(databaseConfig.getUrl());
        return mongoClient.getDatabase(databaseConfig.getDatabaseName());
    }
}
