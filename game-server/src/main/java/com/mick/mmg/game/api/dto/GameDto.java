package com.mick.mmg.game.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mick.mmg.game.entity.GameRules;
import com.mick.mmg.game.entity.GameState;
import com.mick.mmg.game.entity.GameType;

import java.util.List;
import java.util.UUID;

public class GameDto {
    private String code;
    private UUID playlistId;
    private int currentRound;
    private int numberOfRounds;
    @JsonProperty("rules")
    private GameRules gameRules;
    @JsonProperty("state")
    private GameState gameState = GameState.WAITING_TO_START;
    private List<UserDto> users;

    public String getCode() {
        return code;
    }

    public GameDto setCode(String code) {
        this.code = code;
        return this;
    }

    public UUID getPlaylistId() {
        return playlistId;
    }

    public GameDto setPlaylistId(UUID playlistId) {
        this.playlistId = playlistId;
        return this;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public GameDto setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
        return this;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public GameDto setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
        return this;
    }

    public GameState getGameState() {
        return gameState;
    }

    public GameDto setGameState(GameState gameState) {
        this.gameState = gameState;
        return this;
    }

    public GameRules getGameRules() {
        return gameRules;
    }

    public GameDto setGameRules(GameRules gameRules) {
        this.gameRules = gameRules;
        return this;
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public GameDto setUsers(List<UserDto> users) {
        this.users = users;
        return this;
    }
}
