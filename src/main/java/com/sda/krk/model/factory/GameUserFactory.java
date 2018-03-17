package com.sda.krk.model.factory;

import com.sda.krk.model.GameUser;
import com.sda.krk.model.dto.GameUserDto;

public class GameUserFactory {
    public static GameUser createGameUser(GameUserDto gameUserDto) {
        return new GameUser(gameUserDto.getEmail(), gameUserDto.getPasswordHash());
    }
}
