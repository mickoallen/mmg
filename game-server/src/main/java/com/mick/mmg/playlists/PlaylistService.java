package com.mick.mmg.playlists;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    @Inject
    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public List<Playlist> getAll() {
        return playlistRepository.getAll();
    }
}
