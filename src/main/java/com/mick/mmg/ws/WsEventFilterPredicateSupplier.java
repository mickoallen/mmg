package com.mick.mmg.ws;

import io.micronaut.websocket.WebSocketSession;

import java.util.function.Predicate;

public class WsEventFilterPredicateSupplier {
    public static Predicate<WebSocketSession> isValid(String code) {
        return s -> code.equalsIgnoreCase(s.getUriVariables().get("code", String.class, null));
    }
}
