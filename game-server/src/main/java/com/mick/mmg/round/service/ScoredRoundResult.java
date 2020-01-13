package com.mick.mmg.round.service;

public class ScoredRoundResult {
    private int songGuessScore;
    private int artistNameGuessScore;
    private int yearReleasedGuessScore;

    public int getSongGuessScore() {
        return songGuessScore;
    }

    public ScoredRoundResult setSongGuessScore(int songGuessScore) {
        this.songGuessScore = songGuessScore;
        return this;
    }

    public int getArtistNameGuessScore() {
        return artistNameGuessScore;
    }

    public ScoredRoundResult setArtistNameGuessScore(int artistNameGuessScore) {
        this.artistNameGuessScore = artistNameGuessScore;
        return this;
    }

    public int getYearReleasedGuessScore() {
        return yearReleasedGuessScore;
    }

    public ScoredRoundResult setYearReleasedGuessScore(int yearReleasedGuessScore) {
        this.yearReleasedGuessScore = yearReleasedGuessScore;
        return this;
    }
}
