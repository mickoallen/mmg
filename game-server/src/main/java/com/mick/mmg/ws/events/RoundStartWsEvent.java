package com.mick.mmg.ws.events;

public class RoundStartWsEvent extends WsEvent {
    private int roundNumber;
    private String youtubeId;

    public int getRoundNumber() {
        return roundNumber;
    }

    public RoundStartWsEvent setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
        return this;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public RoundStartWsEvent setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
        return this;
    }
}
