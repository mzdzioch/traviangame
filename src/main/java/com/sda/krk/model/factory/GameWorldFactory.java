package com.sda.krk.model.factory;

import com.sda.krk.model.GameWorld;
import com.sda.krk.model.dto.GameWorldDto;

public class GameWorldFactory {
    public static GameWorld createGameWorld(GameWorldDto gameWorldDto) {
        return new GameWorld(gameWorldDto.getName(), gameWorldDto.getSizeRowsColumns());
    }
}
