package com.mick.mmg.ws;

import com.mick.mmg.game.service.GameStartedEvent;
import com.mick.mmg.game.service.UserJoinedGameEvent;
import com.mick.mmg.round.RoundStartEvent;
import com.mick.mmg.ws.events.RoundStartWsEvent;
import com.mick.mmg.ws.events.WsEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.scheduling.annotation.Async;
import io.micronaut.websocket.WebSocketBroadcaster;

import javax.inject.Inject;
import javax.inject.Singleton;

import static com.mick.mmg.ws.WsEventFilterPredicateSupplier.isValid;

@Singleton
public class ApplicationEventHandler {
    private final WsEventBuilder wsEventBuilder;
    private final WebSocketBroadcaster webSocketBroadcaster;

    @Inject
    public ApplicationEventHandler(WsEventBuilder wsEventBuilder, WebSocketBroadcaster webSocketBroadcaster) {
        this.wsEventBuilder = wsEventBuilder;
        this.webSocketBroadcaster = webSocketBroadcaster;
    }

    @EventListener
    @Async
    public void handleGameStartedEvent(final GameStartedEvent gameStartedEvent) {
        WsEvent wsEvent = new WsEvent();
        wsEventBuilder.buildBaseWsEvent(wsEvent, gameStartedEvent.getCode());
        wsEvent.setEventType(WsEventType.GAME_STARTED);

        webSocketBroadcaster.broadcastSync(wsEvent, isValid(wsEvent.getCode()));
    }

    @EventListener
    @Async
    public void handleUserJoinedGameEvent(final UserJoinedGameEvent userJoinedGameEvent) {
        WsEvent wsEvent = new WsEvent();
        wsEventBuilder.buildBaseWsEvent(wsEvent, userJoinedGameEvent.getCode());
        wsEvent.setEventType(WsEventType.USER_JOINED_GAME);

        webSocketBroadcaster.broadcastSync(wsEvent, isValid(wsEvent.getCode()));
    }

    @EventListener
    @Async
    public void handleRoundStartedEvent(final RoundStartEvent roundStartEvent) {
        RoundStartWsEvent wsEvent = new RoundStartWsEvent();
        wsEventBuilder.buildBaseWsEvent(wsEvent, roundStartEvent.getRoundEntity().getGameCode());
        wsEvent.setEventType(WsEventType.ROUND_START);
        wsEvent.setRoundNumber(roundStartEvent.getRoundEntity().getRoundNumber());
        wsEvent.setYoutubeId(roundStartEvent.getRoundEntity().getYoutubeId());
        webSocketBroadcaster.broadcastSync(wsEvent, isValid(wsEvent.getCode()));
    }
}
