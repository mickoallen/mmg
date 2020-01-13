package com.mick.mmg.playlists.api;

import com.mick.mmg.playlists.Playlist;

import java.util.List;
import java.util.stream.Collectors;

public class PlaylistMapper {
    public static PlaylistDto toDto(Playlist playlist) {
        return new PlaylistDto()
                .setId(playlist.getId())
                .setName(playlist.getName());
    }

    public static List<PlaylistDto> toDtos(List<Playlist> playlists) {
        return playlists
                .stream()
                .map(PlaylistMapper::toDto)
                .collect(Collectors.toList());
    }
}
