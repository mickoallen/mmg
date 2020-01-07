package com.mick.mmg.game.entity;

import com.mick.mmg.exceptions.NotFoundException;
import com.mick.mmg.json.JsonCodec;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
public class GameRepository {
    public static final String COLLECTION_NAME = "games";

    private final MongoCollection<Document> collection;

    @Inject
    public GameRepository(@Named(COLLECTION_NAME) final MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public GameEntity create(GameEntity gameEntity) {
        Document document = Document.parse(JsonCodec.serialize(gameEntity));
        collection.insertOne(document);

        return gameEntity;
    }

    public GameEntity update(GameEntity gameEntity) {
        Document document = Document.parse(JsonCodec.serialize(gameEntity));

        collection.replaceOne(
                new Document(GameEntity.CODE_FIELD, gameEntity.getCode()),
                document
        );

        return gameEntity;
    }

    public void addUserToGame(User user, String code) {
        Document userToAddDocument = Document.parse(JsonCodec.serialize(user));

        collection.updateOne(
                new Document(GameEntity.CODE_FIELD, code),
                Updates.addToSet(GameEntity.USERS_FIELD, userToAddDocument)
        );
    }

    public GameEntity get(String code) {
        FindIterable<Document> documents = collection.find(new Document(GameEntity.CODE_FIELD, code));

        if (documents.first() == null) {
            throw new NotFoundException("No game for that code");
        }

        return JsonCodec.deserialize(documents.first().toJson(), GameEntity.class);
    }
}
