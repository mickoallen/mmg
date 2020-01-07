package com.mick.mmg.mmg.game.api;

import io.micronaut.http.HttpRequest;
import io.micronaut.websocket.WebSocketSession;
import io.micronaut.websocket.annotation.ClientWebSocket;
import io.micronaut.websocket.annotation.OnMessage;
import io.micronaut.websocket.annotation.OnOpen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

@ClientWebSocket("/ws/game/{code}")
public class WsClient implements AutoCloseable {

    private static final Logger logger = LoggerFactory.getLogger(WsClient.class);

    private WebSocketSession session;
    private HttpRequest request;
    private String code;
    private Collection<String> replies = new ConcurrentLinkedQueue<>();

    @OnOpen
    public void onOpen(String code, WebSocketSession session, HttpRequest request) {
        this.code = code;
        this.session = session;
        this.request = request;
    }

    @OnMessage
    public void onMessage(String message) {
        logger.info("Ws message received by client: {} for game:{}", message, code);
    }

    @Override
    public void close() {
        "your mom".toUpperCase();
    }

    public Collection<String> getReplies() {
        return replies;
    }

    public WebSocketSession getSession() {
        return session;
    }

    public HttpRequest getRequest() {
        return request;
    }
}
