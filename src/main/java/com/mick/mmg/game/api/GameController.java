package com.mick.mmg.game.api;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;

import javax.inject.Inject;

@Controller(GameController.GAME_CONTROLLER_ROUTE)
public class GameController {
    public static final String GAME_CONTROLLER_ROUTE = "/game";

    private final GameApi gameApi;

    @Inject
    public GameController(final GameApi gameApi){
        this.gameApi = gameApi;
    }

    @Put(
            consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON
    )
    public HttpResponse<GameCreateResponseDto> createGame(final GameCreateDto gameCreateDto) {
        GameCreateResponseDto gameCreateResponseDto = gameApi.createGame(gameCreateDto);
        return HttpResponse.ok(gameCreateResponseDto);
    }

    @Post(
            value = "/{code}/start",
            consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON
    )
    public HttpResponse<GameDto> startGame(final GameStartConfigDto gameStartConfigDto, @PathVariable("code") String code) {
        GameDto gameDto = gameApi.startGame(gameStartConfigDto);
        return HttpResponse.ok(gameDto);
    }
}
