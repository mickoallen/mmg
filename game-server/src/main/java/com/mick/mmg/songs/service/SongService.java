package com.mick.mmg.songs.service;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Singleton
public class SongService {

    private final SongRepository songRepository;

    @Inject
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<SongEntity> getSongsForPlaylist(UUID playlistId, int numberOfSongs){
        return songRepository.getSongsForPlaylist(playlistId)
                .stream()
                .limit(numberOfSongs)
                .collect(Collectors.toList());
    }
}
