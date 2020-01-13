package com.mick.mmg.game.api.dto;

import com.mick.mmg.game.entity.GameRules;

import java.util.UUID;

public class GameStartConfigDto {
    private String code;
    private GameRules gameRules;
    private UUID playlistId;
    private int numberOfRounds;

    public String getCode() {
        return code;
    }

    public GameStartConfigDto setCode(String code) {
        this.code = code;
        return this;
    }

    public GameRules getGameRules() {
        return gameRules;
    }

    public GameStartConfigDto setGameRules(GameRules gameRules) {
        this.gameRules = gameRules;
        return this;
    }

    public UUID getPlaylistId() {
        return playlistId;
    }

    public GameStartConfigDto setPlaylistId(UUID playlistId) {
        this.playlistId = playlistId;
        return this;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public GameStartConfigDto setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
        return this;
    }
}
