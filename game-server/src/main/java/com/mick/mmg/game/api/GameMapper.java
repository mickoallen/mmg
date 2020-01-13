package com.mick.mmg.game.api;

import com.mick.mmg.game.api.dto.GameDto;
import com.mick.mmg.game.entity.GameEntity;

import java.util.stream.Collectors;

public class GameMapper {
    public static GameDto toDto(GameEntity gameEntity){
        return new GameDto()
                .setCode(gameEntity.getCode())
                .setCurrentRound(gameEntity.getCurrentRound())
                .setGameState(gameEntity.getGameState())
                .setNumberOfRounds(gameEntity.getNumberOfRounds())
                .setPlaylistId(gameEntity.getPlaylistId())
                .setUsers(gameEntity.getUsers().stream().map(UserMapper::toDto).collect(Collectors.toList()));

    }
}
