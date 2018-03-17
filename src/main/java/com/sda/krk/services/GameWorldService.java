package com.sda.krk.services;

import com.sda.krk.dao.GameWorldRepository;
import com.sda.krk.model.GameWorld;
import com.sda.krk.model.dto.GameWorldDto;
import com.sda.krk.model.factory.GameWorldFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameWorldService implements IGameWorldService {

    @Autowired
    private GameWorldRepository gameWorldRepository;

    @Override
    public Optional<GameWorld> createGameWorldService(GameWorldDto gameWorldDto) {
        GameWorld gameWorld = gameWorldRepository.save(GameWorldFactory.createGameWorld(gameWorldDto));
        return Optional.ofNullable(gameWorld);
    }
}
