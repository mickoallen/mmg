package com.mick.mmg.round.api;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

import javax.inject.Inject;

@Controller(RoundController.ROUND_ROUTE)
public class RoundController {
    public static final String ROUND_ROUTE = "/api/round";

    private final RoundApi roundApi;

    @Inject
    public RoundController(final RoundApi roundApi) {
        this.roundApi = roundApi;
    }

    @Post(
            value = "/guess",
            produces = MediaType.APPLICATION_JSON,
            consumes = MediaType.APPLICATION_JSON
    )
    public HttpResponse<UserGuessRoundResultDto> roundGuess(final RoundGuessDto roundGuessDto) {
        UserGuessRoundResultDto userGuessRoundResultDto = roundApi.roundGuess(roundGuessDto);

        return HttpResponse.ok(userGuessRoundResultDto);
    }
}
