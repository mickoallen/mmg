package com.mick.mmg.round.entity;

public class UserGuessResult {
    private int songNameGuessAccuracy;
    private int artistNameGuessAccuracy;
    private int yearReleasedGuessAccuracy;

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
