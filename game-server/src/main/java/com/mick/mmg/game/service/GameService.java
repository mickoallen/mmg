package com.mick.mmg.game.service;

import com.mick.mmg.game.entity.GameEntity;
import com.mick.mmg.game.entity.GameRepository;
import com.mick.mmg.game.entity.GameState;
import com.mick.mmg.game.entity.User;
import com.mick.mmg.round.service.RoundService;
import com.mick.mmg.round.entity.RoundEntity;
import com.mick.mmg.songs.service.SongEntity;
import com.mick.mmg.songs.service.SongService;
import io.micronaut.context.event.ApplicationEventPublisher;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Singleton
public class GameService {
    private final GameRepository gameRepository;
    private final RoundService roundService;
    private final SongService songService;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Inject
    public GameService(
            final GameRepository gameRepository,
            final RoundService roundService,
            final SongService songService,
            final ApplicationEventPublisher applicationEventPublisher) {
        this.gameRepository = gameRepository;
        this.roundService = roundService;
        this.songService = songService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public GameEntity create(GameEntity gameEntity) {
        gameEntity.setCode(GameCodeCreator.create());
        return gameRepository.create(gameEntity);
    }

    public GameEntity getGame(String code) {
        return gameRepository.get(code);
    }

    public GameEntity startGame(GameEntity gameEntity) {
        List<SongEntity> songsForPlaylist = songService.getSongsForPlaylist(gameEntity.getPlaylistId(), gameEntity.getNumberOfRounds());

        if(songsForPlaylist.size() < gameEntity.getNumberOfRounds()){
            throw new GameStartException("Failed to get songs for playlist, gameEntity:" + gameEntity);
        }

        List<RoundEntity> rounds = IntStream
                .range(0, gameEntity.getNumberOfRounds())
                .mapToObj(roundNumber -> {
                    SongEntity songEntity = songsForPlaylist.get(roundNumber);

                    return new RoundEntity()
                            .setGameCode(gameEntity.getCode())
                            .setRoundNumber(roundNumber)
                            .setArtistName(songEntity.getArtistName())
                            .setSongName(songEntity.getSongName())
                            .setSongId(songEntity.getId())
                            .setYoutubeId(songEntity.getYoutubeId());
                })
                .collect(Collectors.toList());

        //create rounds
        roundService.createRounds(rounds);

        gameEntity.setGameState(GameState.IN_ROUND);

        gameRepository.update(gameEntity);

        applicationEventPublisher.publishEvent(
                new GameStartedEvent()
                        .setCode(gameEntity.getCode())
        );

        return gameEntity;
    }

    public User addUserToGame(User user, String code) {
        user.setId(UUID.randomUUID());

        gameRepository.addUserToGame(user, code);

        applicationEventPublisher.publishEvent(
                new UserJoinedGameEvent()
                        .setCode(code)
                        .setUser(user)
        );

        return user;
    }
}
