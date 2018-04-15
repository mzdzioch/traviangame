package com.sda.webgame.model.factory;

import com.sda.webgame.model.GameWorld;
import com.sda.webgame.model.dto.GameWorldDto;

public class GameWorldFactory {

    public static GameWorld createGameWorld(GameWorldDto dto){
        return new GameWorld(dto.getName(), dto.getSizeRowsColumns());
    }
}
