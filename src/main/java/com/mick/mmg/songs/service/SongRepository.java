package com.mick.mmg.songs.service;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;
import java.util.UUID;

@Singleton
public class SongRepository {
    public final static String COLLECTION_NAME = "songs";

    private final MongoCollection<Document> collection;

    @Inject
    public SongRepository(@Named(COLLECTION_NAME) MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public List<SongEntity> getSongsForPlaylist(UUID playlistId) {
        return List.of(
                new SongEntity(),
                new SongEntity(),
                new SongEntity(),
                new SongEntity(),
                new SongEntity(),
                new SongEntity(),
                new SongEntity(),
                new SongEntity(),
                new SongEntity(),
                new SongEntity(),
                new SongEntity(),
                new SongEntity(),
                new SongEntity(),
                new SongEntity()
                );
    }
}
