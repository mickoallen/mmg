package com.mick.mmg.game.service;

import com.mick.mmg.game.entity.User;

public class UserJoinedGameEvent {
    private String code;
    private User user;

    public String getCode() {
        return code;
    }

    public UserJoinedGameEvent setCode(String code) {
        this.code = code;
        return this;
    }

    public User getUser() {
        return user;
    }

    public UserJoinedGameEvent setUser(User user) {
        this.user = user;
        return this;
    }
}
