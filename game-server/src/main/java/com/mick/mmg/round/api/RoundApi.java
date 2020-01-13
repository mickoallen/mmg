package com.mick.mmg.round.api;

import com.mick.mmg.round.entity.UserGuessResult;
import com.mick.mmg.round.entity.UserRoundGuess;
import com.mick.mmg.round.service.RoundService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RoundApi {
    private final RoundService roundService;

    @Inject
    public RoundApi(RoundService roundService) {
        this.roundService = roundService;
    }

    public UserGuessRoundResultDto roundGuess(RoundGuessDto roundGuessDto) {
        UserRoundGuess userRoundGuess = UserRoundGuessMapper.toEntity(roundGuessDto);
        UserGuessResult userGuessResult = roundService.roundGuess(roundGuessDto.getCode(), userRoundGuess);

        return new UserGuessRoundResultDto()
                .setArtistNameGuessAccuracy(userGuessResult.getArtistNameGuessAccuracy())
                .setSongNameGuessAccuracy(userGuessResult.getSongNameGuessAccuracy())
                .setYearReleasedGuessAccuracy(userGuessResult.getYearReleasedGuessAccuracy())
                .setScoredRoundResult(ScoredRoundResultDtoMapper.toDto(userGuessResult.getScoredRoundResult()));

    }
}
