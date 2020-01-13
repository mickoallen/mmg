package com.mick.mmg.round.api;

import com.mick.mmg.round.service.ScoredRoundResult;

public class ScoredRoundResultDtoMapper {
    public static ScoredRoundResultDto toDto(ScoredRoundResult scoredRoundResult) {
        return new ScoredRoundResultDto()
                .setArtistNameGuessScore(scoredRoundResult.getArtistNameGuessScore())
                .setSongGuessScore(scoredRoundResult.getSongGuessScore())
                .setYearReleasedGuessScore(scoredRoundResult.getYearReleasedGuessScore());
    }
}
