package com.sda.krk.services;

import com.sda.krk.model.GameWorld;
import com.sda.krk.model.dto.GameWorldDto;

import java.util.Optional;

public interface IGameWorldService {
    Optional<GameWorld> createGameWorldService(GameWorldDto gameWorldDto);
}
