package com.mick.mmg.game.api;

import com.mick.mmg.game.api.dto.*;
import com.mick.mmg.game.entity.GameEntity;
import com.mick.mmg.game.entity.User;
import com.mick.mmg.game.service.GameService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.UUID;

@Singleton
public class GameApi {
    public final GameService gameService;

    @Inject
    public GameApi(final GameService gameService) {
        this.gameService = gameService;
    }

    public GameCreateResponseDto createGame(final UserCreateDto userCreateDto) {
        GameEntity gameEntity = gameService.create(new GameEntity());

        User user = new User()
                .setHost(true)
                .setUsername(userCreateDto.getUsername());
        user = gameService.addUserToGame(user, gameEntity.getCode());

        return new GameCreateResponseDto()
                .setUserDto(UserMapper.toDto(user))
                .setGameDto(GameMapper.toDto(gameEntity));
    }

    public GameDto getGame(String code) {
        GameEntity gameEntity = gameService.getGame(code);
        return GameMapper.toDto(gameEntity);
    }

    public GameDto startGame(GameStartConfigDto startConfigDto) {
        GameEntity gameEntity = gameService.getGame(startConfigDto.getCode());

        gameEntity
                .setGameType(startConfigDto.getGameType())
                .setNumberOfRounds(startConfigDto.getNumberOfRounds())
                .setPlaylistId(startConfigDto.getPlaylistId());

        return GameMapper.toDto(gameService.startGame(gameEntity));
    }

    public UserDto joinGame(UserCreateDto userCreateDto, String code) {
        User user = new User()
                .setUsername(userCreateDto.getUsername())
                .setHost(false)
                .setId(UUID.randomUUID());
        gameService.addUserToGame(user, code);
        return UserMapper.toDto(user);
    }


}
