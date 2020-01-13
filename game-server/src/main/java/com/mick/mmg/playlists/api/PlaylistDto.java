package com.mick.mmg.playlists.api;

import java.util.UUID;

public class PlaylistDto {
    private UUID id;
    private String name;

    public UUID getId() {
        return id;
    }

    public PlaylistDto setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PlaylistDto setName(String name) {
        this.name = name;
        return this;
    }
}
