package com.mick.mmg.game.api;

import com.mick.mmg.game.api.dto.*;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;

@Controller(GameController.GAME_CONTROLLER_ROUTE)
public class GameController {
    public static final String GAME_CONTROLLER_ROUTE = "/api/game";

    private final GameApi gameApi;

    @Inject
    public GameController(final GameApi gameApi) {
        this.gameApi = gameApi;
    }

    @Put(
            consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON
    )
    public HttpResponse<GameCreateResponseDto> createGame(final UserCreateDto userCreateDto) {
        GameCreateResponseDto gameCreateResponseDto = gameApi.createGame(userCreateDto);
        return HttpResponse.ok(gameCreateResponseDto);
    }

    @Get(
            value = "/{code}",
            produces = MediaType.APPLICATION_JSON
    )
    public HttpResponse<GameDto> getGame(@PathVariable("code") String code){
        GameDto gameDto = gameApi.getGame(code);
        return HttpResponse.ok(gameDto);
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

    @Post(
            value = "/{code}/join",
            consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON
    )
    public HttpResponse<UserDto> joinGame(final UserCreateDto userCreateDto, @PathVariable("code") String code) {
        UserDto userDto = gameApi.joinGame(userCreateDto, code);
        return HttpResponse.ok(userDto);
    }
}
