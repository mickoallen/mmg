package com.mick.mmg.ws;

import com.mick.mmg.game.service.GameService;
import io.micronaut.websocket.WebSocketBroadcaster;
import io.micronaut.websocket.WebSocketSession;
import io.micronaut.websocket.annotation.OnClose;
import io.micronaut.websocket.annotation.OnMessage;
import io.micronaut.websocket.annotation.OnOpen;
import io.micronaut.websocket.annotation.ServerWebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@ServerWebSocket("/ws/game/{code}")
public class WsSocketHandler {
    private static final Logger logger = LoggerFactory.getLogger(WsSocketHandler.class);

    private final WebSocketBroadcaster broadcaster;
    private final GameService gameService;

    @Inject
    public WsSocketHandler(WebSocketBroadcaster broadcaster, GameService gameService) {
        this.broadcaster = broadcaster;
        this.gameService = gameService;
    }

    @OnOpen
    public void onOpen(String code, WebSocketSession session) {
        logger.info("Ws connection established for game:{}", code);
    }

    @OnMessage
    public void onMessage(
            String code,
            String message,
            WebSocketSession session) {
        logger.error("ws message received, that shouldn't happen");
    }

    @OnClose
    public void onClose(
            String code,
            WebSocketSession session) {
        logger.info("ws connection terminated for game:{}", code);
    }
}
