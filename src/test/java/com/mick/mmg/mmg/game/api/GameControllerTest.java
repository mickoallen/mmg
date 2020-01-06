package com.mick.mmg.mmg.game.api;

import com.mick.mmg.game.api.GameController;
import com.mick.mmg.game.api.GameCreateDto;
import com.mick.mmg.game.api.GameCreateResponseDto;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.websocket.RxWebSocketClient;
import io.micronaut.websocket.WebSocketClient;
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
    public void testThing() {
        HttpResponse<GameCreateResponseDto> response = client
                .toBlocking()
                .exchange(HttpRequest.PUT("/game", new GameCreateDto().setUsername("mick")), GameCreateResponseDto.class);

        response.toString();
    }
}
