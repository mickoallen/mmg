package com.mick.mmg.round.entity;

import com.mick.mmg.round.service.ScoredRoundResult;

public class UserGuessResult {
    private final UserRoundGuess userRoundGuess;
    private ScoredRoundResult scoredRoundResult;
    private int songNameGuessAccuracy;
    private int artistNameGuessAccuracy;
    private int yearReleasedGuessAccuracy;

    public UserGuessResult(UserRoundGuess userRoundGuess) {
        this.userRoundGuess = userRoundGuess;
    }

    public UserRoundGuess getUserRoundGuess() {
        return userRoundGuess;
    }

    public ScoredRoundResult getScoredRoundResult() {
        return scoredRoundResult;
    }

    public UserGuessResult setScoredRoundResult(ScoredRoundResult scoredRoundResult) {
        this.scoredRoundResult = scoredRoundResult;
        return this;
    }

    public int getSongNameGuessAccuracy() {
        return songNameGuessAccuracy;
    }

    public UserGuessResult setSongNameGuessAccuracy(int songNameGuessAccuracy) {
        this.songNameGuessAccuracy = songNameGuessAccuracy;
        return this;
    }

    public int getArtistNameGuessAccuracy() {
        return artistNameGuessAccuracy;
    }

    public UserGuessResult setArtistNameGuessAccuracy(int artistNameGuessAccuracy) {
        this.artistNameGuessAccuracy = artistNameGuessAccuracy;
        return this;
    }

    public int getYearReleasedGuessAccuracy() {
        return yearReleasedGuessAccuracy;
    }

    public UserGuessResult setYearReleasedGuessAccuracy(int yearReleasedGuessAccuracy) {
        this.yearReleasedGuessAccuracy = yearReleasedGuessAccuracy;
        return this;
    }
}
