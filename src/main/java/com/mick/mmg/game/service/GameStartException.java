package com.mick.mmg.game.service;

import com.mick.mmg.game.entity.GameEntity;

public class GameStartException extends RuntimeException {
    public GameStartException(String message) {
        super(message);
    }

    public GameStartException(String message, Throwable cause) {
        super(message, cause);
    }
}
