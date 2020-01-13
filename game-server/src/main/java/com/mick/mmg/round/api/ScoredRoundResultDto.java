package com.mick.mmg.round.api;

public class ScoredRoundResultDto {
    private int songGuessScore;
    private int artistNameGuessScore;
    private int yearReleasedGuessScore;

    public int getSongGuessScore() {
        return songGuessScore;
    }

    public ScoredRoundResultDto setSongGuessScore(int songGuessScore) {
        this.songGuessScore = songGuessScore;
        return this;
    }

    public int getArtistNameGuessScore() {
        return artistNameGuessScore;
    }

    public ScoredRoundResultDto setArtistNameGuessScore(int artistNameGuessScore) {
        this.artistNameGuessScore = artistNameGuessScore;
        return this;
    }

    public int getYearReleasedGuessScore() {
        return yearReleasedGuessScore;
    }

    public ScoredRoundResultDto setYearReleasedGuessScore(int yearReleasedGuessScore) {
        this.yearReleasedGuessScore = yearReleasedGuessScore;
        return this;
    }
}
