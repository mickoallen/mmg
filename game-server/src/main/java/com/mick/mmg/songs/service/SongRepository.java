package com.mick.mmg.songs.service;

import com.mick.mmg.json.JsonCodec;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ArrayList;
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
        FindIterable<Document> songs = collection.find(new Document(SongEntity.PLAYLIST_ID_FIELD, playlistId.toString()));

        List<SongEntity> songEntities = new ArrayList<>();
        for (Document song : songs) {
            songEntities.add(JsonCodec.deserialize(song.toJson(), SongEntity.class));
        }

        return songEntities;
    }
}
