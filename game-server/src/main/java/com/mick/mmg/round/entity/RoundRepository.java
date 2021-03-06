package com.mick.mmg.round.entity;

import com.mick.mmg.json.JsonCodec;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class RoundRepository {
    public static final String COLLECTION_NAME = "rounds";

    private final MongoCollection<Document> collection;

    public RoundRepository(@Named(COLLECTION_NAME) MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public List<RoundEntity> create(List<RoundEntity> rounds) {
        List<Document> roundDocuments = rounds
                .stream()
                .map(JsonCodec::serialize)
                .map(Document::parse)
                .collect(Collectors.toList());

        collection.insertMany(roundDocuments);

        return rounds;
    }

    public List<RoundEntity> getRoundsForGame(String code) {
        FindIterable<Document> documents = collection.find(new Document(RoundEntity.GAME_CODE_FIELD, code));

        List<RoundEntity> rounds = new ArrayList<>();
        for (Document document : documents) {
            rounds.add(JsonCodec.deserialize(document.toJson(), RoundEntity.class));
        }

        return rounds;
    }
}
