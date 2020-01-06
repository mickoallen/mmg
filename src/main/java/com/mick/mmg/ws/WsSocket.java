package com.mick.mmg.ws;

import io.micronaut.websocket.WebSocketBroadcaster;
import io.micronaut.websocket.WebSocketSession;
import io.micronaut.websocket.annotation.OnClose;
import io.micronaut.websocket.annotation.OnOpen;
import io.micronaut.websocket.annotation.ServerWebSocket;
import org.reactivestreams.Publisher;

import java.util.UUID;

import static com.mick.mmg.ws.WsEventFilterPredicateSupplier.isValid;

@ServerWebSocket("/ws/game/{code}/{userId}")
public class WsSocket {
    private WebSocketBroadcaster broadcaster;

    @OnOpen
    public Publisher<String> onOpen(String code, String userId, WebSocketSession session) {
        String msg = "[" + userId + "] Joined!";
        return broadcaster.broadcast(msg, isValid(code));
    }

    @OnClose
    public Publisher<String> onClose(
            String code,
            UUID userId,
            WebSocketSession session) {
        String msg = "[" + userId + "] Disconnected!";
        return broadcaster.broadcast(msg, isValid(code));
    }
}
