package com.mick.mmg.playlists;

import com.mick.mmg.json.JsonCodec;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class PlaylistRepository {
    public static final String COLLECTION_NAME = "playlists";

    private final MongoCollection<Document> collection;

    public PlaylistRepository(@Named(COLLECTION_NAME) MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public List<Playlist> getAll() {
        List<Playlist> playlists = new ArrayList<>();

        for (Document document : collection.find()) {
            playlists.add(JsonCodec.deserialize(document.toJson(), Playlist.class));
        }

        return playlists;
    }
}
