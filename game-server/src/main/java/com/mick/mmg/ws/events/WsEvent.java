package com.mick.mmg.ws.events;

import com.mick.mmg.game.api.dto.GameDto;
import com.mick.mmg.ws.WsEventType;

public class WsEvent {
    private String code;
    private WsEventType eventType;
    private GameDto gameDto;

    public String getCode() {
        return code;
    }

    public WsEvent setCode(String code) {
        this.code = code;
        return this;
    }

    public WsEventType getEventType() {
        return eventType;
    }

    public WsEvent setEventType(WsEventType eventType) {
        this.eventType = eventType;
        return this;
    }
}
