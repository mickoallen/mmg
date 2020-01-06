package com.mick.mmg.game.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameCreateResponseDto {
    @JsonProperty("user")
    private UserDto userDto;
    @JsonProperty("game")
    private GameDto gameDto;

    public GameCreateResponseDto() {
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public GameCreateResponseDto setUserDto(UserDto userDto) {
        this.userDto = userDto;
        return this;
    }

    public GameDto getGameDto() {
        return gameDto;
    }

    public GameCreateResponseDto setGameDto(GameDto gameDto) {
        this.gameDto = gameDto;
        return this;
    }
}
