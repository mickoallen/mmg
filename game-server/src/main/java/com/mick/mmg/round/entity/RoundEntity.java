package com.mick.mmg.round.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoundEntity {
    @JsonIgnore
    public static final String GAME_CODE_FIELD = "gameCode";

    @JsonProperty(GAME_CODE_FIELD)
    private String gameCode;
    private int roundNumber;
    private String songName;
    private String artistName;
    private String youtubeId;
    private Integer yearReleased;
    private UUID songId;
    private List<UserRoundGuess> userRoundGuesses = new ArrayList<>();

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

    public Integer getYearReleased() {
        return yearReleased;
    }

    public RoundEntity setYearReleased(Integer yearReleased) {
        this.yearReleased = yearReleased;
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

    public List<UserRoundGuess> getUserRoundGuesses() {
        return userRoundGuesses;
    }

    public RoundEntity setUserRoundGuesses(List<UserRoundGuess> userRoundGuesses) {
        this.userRoundGuesses = userRoundGuesses;
        return this;
    }
}
