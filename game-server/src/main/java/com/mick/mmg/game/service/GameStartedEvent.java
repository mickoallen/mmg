package com.mick.mmg.game.service;

public class GameStartedEvent {
    private String code;

    public String getCode() {
        return code;
    }

    public GameStartedEvent setCode(String code) {
        this.code = code;
        return this;
    }
}
