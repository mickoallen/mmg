package com.mick.mmg.round.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RoundEntity {
    private String gameCode;
    private int roundNumber;
    private String songName;
    private String artistName;
    private String youtubeId;
    private UUID songId;
    private List<UserGuess> userGuesses = new ArrayList<>();

    public String getGameCode() {
        return gameCode;
    }

    public RoundEntity setGameCode(String gameCode) {
        this.gameCode = gameCode;
        return this;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public RoundEntity setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
        return this;
    }

    public String getSongName() {
        return songName;
    }

    public RoundEntity setSongName(String songName) {
        this.songName = songName;
        return this;
    }

    public String getArtistName() {
        return artistName;
    }

    public RoundEntity setArtistName(String artistName) {
        this.artistName = artistName;
        return this;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public RoundEntity setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
        return this;
    }

    public UUID getSongId() {
        return songId;
    }

    public RoundEntity setSongId(UUID songId) {
        this.songId = songId;
        return this;
    }

    public List<UserGuess> getUserGuesses() {
        return userGuesses;
    }

    public RoundEntity setUserGuesses(List<UserGuess> userGuesses) {
        this.userGuesses = userGuesses;
        return this;
    }
}
