package com.mick.mmg.game.api;

public class GameCreateDto {
    private String username;

    public String getUsername() {
        return username;
    }

    public GameCreateDto setUsername(String username) {
        this.username = username;
        return this;
    }
}
