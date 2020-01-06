package com.mick.mmg.game.entity;

import java.util.UUID;

public class User {
    private UUID id;
    private String username;
    private boolean host;

    public UUID getId() {
        return id;
    }

    public User setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public boolean isHost() {
        return host;
    }

    public User setHost(boolean host) {
        this.host = host;
        return this;
    }
}
