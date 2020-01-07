package com.mick.mmg.round.entity;

import java.util.UUID;

public class UserRoundGuess {
    private int roundNumber;
    private UUID userId;
    private String songName;
    private String artistName;
    private Integer yearReleased;
    private Double percent;
    private long timeTaken;

    public int getRoundNumber() {
        return roundNumber;
    }

    public UserRoundGuess setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
        return this;
    }

    public UUID getUserId() {
        return userId;
    }

    public UserRoundGuess setUserId(UUID userId) {
        this.userId = userId;
        return this;
    }

    public String getSongName() {
        return songName;
    }

    public UserRoundGuess setSongName(String songName) {
        this.songName = songName;
        return this;
    }

    public String getArtistName() {
        return artistName;
    }

    public UserRoundGuess setArtistName(String artistName) {
        this.artistName = artistName;
        return this;
    }

    public Integer getYearReleased() {
        return yearReleased;
    }

    public UserRoundGuess setYearReleased(Integer yearReleased) {
        this.yearReleased = yearReleased;
        return this;
    }

    public Double getPercent() {
        return percent;
    }

    public UserRoundGuess setPercent(Double percent) {
        this.percent = percent;
        return this;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    public UserRoundGuess setTimeTaken(long timeTaken) {
        this.timeTaken = timeTaken;
        return this;
    }
}
