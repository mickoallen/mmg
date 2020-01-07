package com.mick.mmg.round.api;

import java.util.UUID;

public class RoundGuessDto {
    private String code;
    private int roundNumber;
    private UUID userId;
    private String username;
    private String songNameGuess;
    private String artistNameGuess;
    private Integer yearReleasedGuess;
    private long timeTaken;

    public String getCode() {
        return code;
    }

    public RoundGuessDto setCode(String code) {
        this.code = code;
        return this;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public RoundGuessDto setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
        return this;
    }

    public UUID getUserId() {
        return userId;
    }

    public RoundGuessDto setUserId(UUID userId) {
        this.userId = userId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public RoundGuessDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getSongNameGuess() {
        return songNameGuess;
    }

    public RoundGuessDto setSongNameGuess(String songNameGuess) {
        this.songNameGuess = songNameGuess;
        return this;
    }

    public String getArtistNameGuess() {
        return artistNameGuess;
    }

    public RoundGuessDto setArtistNameGuess(String artistNameGuess) {
        this.artistNameGuess = artistNameGuess;
        return this;
    }

    public Integer getYearReleasedGuess() {
        return yearReleasedGuess;
    }

    public RoundGuessDto setYearReleasedGuess(Integer yearReleasedGuess) {
        this.yearReleasedGuess = yearReleasedGuess;
        return this;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    public RoundGuessDto setTimeTaken(long timeTaken) {
        this.timeTaken = timeTaken;
        return this;
    }
}
