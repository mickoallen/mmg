package com.mick.mmg.game.api.dto;

public class UserCreateDto {
    private String username;

    public String getUsername() {
        return username;
    }

    public UserCreateDto setUsername(String username) {
        this.username = username;
        return this;
    }
}
