package com.mick.mmg.songs.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SongEntity {
    @JsonIgnore
    public static final String PLAYLIST_ID_FIELD = "playlistId";

    private UUID id;
    @JsonProperty(PLAYLIST_ID_FIELD)
    private UUID playlistId;
    private String artistName;
    private String songName;
    private String spotifyId;
    private Integer yearRelease;
    private String youtubeId;

    public SongEntity() {
    }

    public UUID getId() {
        return id;
    }

    public SongEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public UUID getPlaylistId() {
        return playlistId;
    }

    public SongEntity setPlaylistId(UUID playlistId) {
        this.playlistId = playlistId;
        return this;
    }

    public String getArtistName() {
        return artistName;
    }

    public SongEntity setArtistName(String artistName) {
        this.artistName = artistName;
        return this;
    }

    public String getSongName() {
        return songName;
    }

    public SongEntity setSongName(String songName) {
        this.songName = songName;
        return this;
    }

    public String getSpotifyId() {
        return spotifyId;
    }

    public SongEntity setSpotifyId(String spotifyId) {
        this.spotifyId = spotifyId;
        return this;
    }

    public Integer getYearRelease() {
        return yearRelease;
    }

    public SongEntity setYearRelease(Integer yearRelease) {
        this.yearRelease = yearRelease;
        return this;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public SongEntity setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
        return this;
    }
}
