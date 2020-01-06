package com.mick.mmg.game.api;

import com.mick.mmg.game.entity.User;

public class UserMapper {
    public static UserDto toDto(User user) {
        return new UserDto()
                .setId(user.getId())
                .setUsername(user.getUsername());
    }
}
