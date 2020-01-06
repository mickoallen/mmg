package com.mick.mmg.ws;

import com.mick.mmg.game.service.GameStartedEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.scheduling.annotation.Async;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class WsOutboundEventHandler {
    private final WsEventBuilder wsEventBuilder;

    @Inject
    public WsOutboundEventHandler(WsEventBuilder wsEventBuilder) {
        this.wsEventBuilder = wsEventBuilder;
    }

    @EventListener
    @Async
    public void handleGameStartedEvent(final GameStartedEvent gameStartedEvent){
        wsEventBuilder.buildBaseWsEvent(gameStartedEvent.getCode());
    }
}
