package com.mick.mmg.ws;

import com.mick.mmg.game.service.GameService;
import com.mick.mmg.round.RoundService;
import com.mick.mmg.songs.service.SongService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class WsEventBuilder {
    private final GameService gameService;
    private final RoundService roundService;
    private final SongService songService;

    @Inject
    public WsEventBuilder(
            final GameService gameService,
            final RoundService roundService,
            final SongService songService) {
        this.gameService = gameService;
        this.roundService = roundService;
        this.songService = songService;
    }

    public WsEvent buildBaseWsEvent(String code) {
        return null;
    }
}
