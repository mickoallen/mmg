package com.mick.mmg.game.api;

import java.util.UUID;

public class UserDto {
    private UUID id;
    private String username;

    public UUID getId() {
        return id;
    }

    public UserDto setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDto setUsername(String username) {
        this.username = username;
        return this;
    }
}
