package com.mick.mmg.mmg.game.api;

import com.mick.mmg.game.api.GameController;
import com.mick.mmg.game.api.dto.GameCreateResponseDto;
import com.mick.mmg.game.api.dto.UserCreateDto;
import com.mick.mmg.game.api.dto.UserDto;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.websocket.RxWebSocketClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.inject.Inject;

@MicronautTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GameControllerTest {
    private GameController gameController;

    @Inject
    @Client("/")
    private RxHttpClient client;

    @Inject
    @Client("/")
    private RxWebSocketClient wsClient;

    @Test
    public void testGameCreate() throws InterruptedException {
        HttpResponse<GameCreateResponseDto> response = client
                .toBlocking()
                .exchange(HttpRequest.PUT("/game", new UserCreateDto().setUsername("mick")), GameCreateResponseDto.class);

        //game created
        GameCreateResponseDto gameCreateResponseDto = response.body();

        //create ws connection
        String connectionUrl = "/ws/game/" + gameCreateResponseDto.getGameDto().getCode();
        WsClient wsClient = this.wsClient.connect(WsClient.class, connectionUrl).blockingFirst();

        HttpResponse<UserDto> userJoinResponse = client
                .toBlocking()
                .exchange(
                        HttpRequest.POST(
                                "/game/" + gameCreateResponseDto.getGameDto().getCode() + "/join",
                                new UserCreateDto().setUsername("simon")
                        ),
                        UserDto.class
                );

        UserDto body = userJoinResponse.body();
        Thread.sleep(1000);
    }
}
