package com.mick.mmg.playlists;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mick.mmg.json.JsonCodec;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.InsertOneModel;
import io.micronaut.context.annotation.Context;
import io.netty.util.internal.ResourcesUtil;
import org.bson.Document;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Singleton;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
@Context
public class PlaylistSeedService {
    private final MongoCollection<Document> collection;
    private final ObjectMapper objectMapper;

    public PlaylistSeedService(@Named(PlaylistRepository.COLLECTION_NAME) MongoCollection<Document> collection) {
        this.collection = collection;
        objectMapper = new ObjectMapper();
    }

    @PostConstruct
    public void seedPlaylists() throws Exception{
        collection.deleteMany(new Document());

        File playlistsFile = ResourcesUtil.getFile(this.getClass(), "/data/playlists.json");
        Playlists playlists = objectMapper.readValue(playlistsFile, Playlists.class);

        collection.bulkWrite(
                playlists
                        .playlists
                        .stream()
                        .map(JsonCodec::serialize)
                        .map(Document::parse)
                        .map(InsertOneModel::new)
                        .collect(Collectors.toList())
        );
    }

    public static class Playlists{
        public List<Playlist> playlists;
    }
}
