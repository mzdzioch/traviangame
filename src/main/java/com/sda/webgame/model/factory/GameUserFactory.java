package com.sda.webgame.model.factory;

import com.sda.webgame.model.GameUser;
import com.sda.webgame.model.dto.GameUserDto;

public class GameUserFactory {

    public static GameUser createGameUser(GameUserDto dto) {
        return new GameUser(dto.getEmail(), dto.getPasswordHash());
    }
}
