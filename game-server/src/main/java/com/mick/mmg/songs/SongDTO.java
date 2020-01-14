package com.mick.mmg.songs;

import java.util.UUID;

public class SongDTO {
    private UUID id;
    private String artistName;
    private String songName;
    private int yearReleased;
    private String youtubeId;

    public UUID getId() {
        return id;
    }

    public SongDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getArtistName() {
        return artistName;
    }

    public SongDTO setArtistName(String artistName) {
        this.artistName = artistName;
        return this;
    }

    public String getSongName() {
        return songName;
    }

    public SongDTO setSongName(String songName) {
        this.songName = songName;
        return this;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public SongDTO setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
        return this;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public SongDTO setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
        return this;
    }
}
