package com.mick.mmg.game.entity;

public class GameRules {
    private boolean songNameGuess;
    private boolean artistNameGuess;
    private boolean yearReleasedGuess;

    public boolean isSongNameGuess() {
        return songNameGuess;
    }

    public GameRules setSongNameGuess(boolean songNameGuess) {
        this.songNameGuess = songNameGuess;
        return this;
    }

    public boolean isArtistNameGuess() {
        return artistNameGuess;
    }

    public GameRules setArtistNameGuess(boolean artistNameGuess) {
        this.artistNameGuess = artistNameGuess;
        return this;
    }

    public boolean isYearReleasedGuess() {
        return yearReleasedGuess;
    }

    public GameRules setYearReleasedGuess(boolean yearReleasedGuess) {
        this.yearReleasedGuess = yearReleasedGuess;
        return this;
    }
}
