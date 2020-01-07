package com.mick.mmg.game.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameEntity {
    @JsonIgnore
    public final static String CODE_FIELD = "code";
    public static final String USERS_FIELD = "users";

    @JsonProperty(CODE_FIELD)
    private String code;
    private UUID playlistId;
    private int currentRound;
    private int numberOfRounds;
    private GameState gameState = GameState.WAITING_TO_START;
    private GameType gameType;
    @JsonProperty(USERS_FIELD)
    private List<User> users = new ArrayList<>();

    public GameEntity(){
    }

    public String getCode() {
        return code;
    }

    public GameEntity setCode(String code) {
        this.code = code;
        return this;
    }

    public UUID getPlaylistId() {
        return playlistId;
    }

    public GameEntity setPlaylistId(UUID playlistId) {
        this.playlistId = playlistId;
        return this;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public GameEntity setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
        return this;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public GameEntity setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
        return this;
    }

    public GameState getGameState() {
        return gameState;
    }

    public GameEntity setGameState(GameState gameState) {
        this.gameState = gameState;
        return this;
    }

    public GameType getGameType() {
        return gameType;
    }

    public GameEntity setGameType(GameType gameType) {
        this.gameType = gameType;
        return this;
    }

    public List<User> getUsers() {
        return users;
    }

    public GameEntity setUsers(List<User> users) {
        this.users = users;
        return this;
    }
}
