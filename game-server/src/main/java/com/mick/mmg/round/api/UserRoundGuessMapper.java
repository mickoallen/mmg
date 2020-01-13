package com.mick.mmg.round.api;

import com.mick.mmg.round.entity.UserRoundGuess;

public class UserRoundGuessMapper {
    public static UserRoundGuess toEntity(RoundGuessDto roundGuessDto) {
        return new UserRoundGuess()
                .setArtistName(roundGuessDto.getArtistNameGuess())
                .setRoundNumber(roundGuessDto.getRoundNumber())
                .setSongName(roundGuessDto.getSongNameGuess())
                .setTimeTaken(roundGuessDto.getTimeTaken())
                .setUserId(roundGuessDto.getUserId())
                .setYearReleased(roundGuessDto.getYearReleasedGuess());
    }

}
