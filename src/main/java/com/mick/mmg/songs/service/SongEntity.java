package com.mick.mmg.songs.service;

import java.util.UUID;

public class SongEntity {
    private UUID id;
    private String artistName;
    private String songName;
    private Integer yearRelease;
    private String youtubeId;

    public UUID getId() {
        return id;
    }

    public SongEntity setId(UUID id) {
        this.id = id;
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
