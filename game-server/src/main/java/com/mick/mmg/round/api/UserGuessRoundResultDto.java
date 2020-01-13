package com.mick.mmg.round.api;


public class UserGuessRoundResultDto {
    private RoundGuessDto roundGuessDto;
    private ScoredRoundResultDto scoredRoundResult;
    private int songNameGuessAccuracy;
    private int artistNameGuessAccuracy;
    private int yearReleasedGuessAccuracy;

    public RoundGuessDto getRoundGuessDto() {
        return roundGuessDto;
    }

    public UserGuessRoundResultDto setRoundGuessDto(RoundGuessDto roundGuessDto) {
        this.roundGuessDto = roundGuessDto;
        return this;
    }

    public ScoredRoundResultDto getScoredRoundResult() {
        return scoredRoundResult;
    }

    public UserGuessRoundResultDto setScoredRoundResult(ScoredRoundResultDto scoredRoundResult) {
        this.scoredRoundResult = scoredRoundResult;
        return this;
    }

    public int getSongNameGuessAccuracy() {
        return songNameGuessAccuracy;
    }

    public UserGuessRoundResultDto setSongNameGuessAccuracy(int songNameGuessAccuracy) {
        this.songNameGuessAccuracy = songNameGuessAccuracy;
        return this;
    }

    public int getArtistNameGuessAccuracy() {
        return artistNameGuessAccuracy;
    }

    public UserGuessRoundResultDto setArtistNameGuessAccuracy(int artistNameGuessAccuracy) {
        this.artistNameGuessAccuracy = artistNameGuessAccuracy;
        return this;
    }

    public int getYearReleasedGuessAccuracy() {
        return yearReleasedGuessAccuracy;
    }

    public UserGuessRoundResultDto setYearReleasedGuessAccuracy(int yearReleasedGuessAccuracy) {
        this.yearReleasedGuessAccuracy = yearReleasedGuessAccuracy;
        return this;
    }
}
