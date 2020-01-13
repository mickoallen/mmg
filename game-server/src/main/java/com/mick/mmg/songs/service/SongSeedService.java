package com.mick.mmg.songs.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mick.mmg.json.JsonCodec;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.InsertOneModel;
import io.micronaut.context.annotation.Context;
import io.netty.util.internal.ResourcesUtil;
import org.bson.Document;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
@Context
public class SongSeedService {
    private final MongoCollection<Document> collection;
    private final ObjectMapper objectMapper;

    @Inject
    public SongSeedService(@Named(SongRepository.COLLECTION_NAME) MongoCollection<Document> collection) {
        this.collection = collection;
        this.objectMapper = new ObjectMapper();
    }

    @PostConstruct
    public void postConstruct() throws Exception {
        collection.deleteMany(new Document());

        File songsFile = ResourcesUtil.getFile(this.getClass(), "/data/songs.json");

        Songs songs = objectMapper.readValue(songsFile, Songs.class);

        collection.bulkWrite(
                songs
                        .songs
                        .stream()
                        .map(JsonCodec::serialize)
                        .map(Document::parse)
                        .map(InsertOneModel::new)
                        .collect(Collectors.toList())
        );
    }

    public static class Songs {
        public List<SongEntity> songs;
    }
}
