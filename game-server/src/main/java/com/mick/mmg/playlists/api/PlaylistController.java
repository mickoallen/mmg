package com.mick.mmg.playlists.api;

import com.mick.mmg.playlists.Playlist;
import com.mick.mmg.playlists.PlaylistService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;
import java.util.List;

@Controller(PlaylistController.PLAYLIST_ROUTE)
public class PlaylistController {
    public static final String PLAYLIST_ROUTE = "/api/playlists";

    private final PlaylistService playlistService;

    @Inject
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Get(
            produces = MediaType.APPLICATION_JSON
    )
    public HttpResponse<List<PlaylistDto>> getPlaylists() {
        List<Playlist> playlists = playlistService.getAll();

        return HttpResponse.ok(PlaylistMapper.toDtos(playlists));
    }
}
