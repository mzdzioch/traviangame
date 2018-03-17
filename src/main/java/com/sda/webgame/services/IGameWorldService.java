package com.sda.webgame.services;

import com.sda.webgame.model.GameWorld;
import com.sda.webgame.model.dto.GameWorldDto;

import java.util.Optional;

public interface IGameWorldService {
    Optional<GameWorld> createGameWorld(GameWorldDto dto);
}
