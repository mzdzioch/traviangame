package com.sda.krk.services;

import com.sda.krk.dao.GameWorldFieldRepository;
import com.sda.krk.dao.GameWorldRepository;
import com.sda.krk.model.GameWorld;
import com.sda.krk.model.GameWorldField;
import com.sda.krk.model.dto.GameWorldDto;
import com.sda.krk.model.factory.GameWorldFactory;
import com.sda.krk.model.factory.GameWorldFieldFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameWorldService implements IGameWorldService {

    @Autowired
    private GameWorldRepository gameWorldRepository;

    @Autowired
    private GameWorldFieldRepository gameWorldFieldRepository;

    @Override
    public Optional<GameWorld> createGameWorldService(GameWorldDto gameWorldDto) {
        GameWorld gameWorld = null;
        try {
            gameWorld = gameWorldRepository.save(GameWorldFactory.createGameWorld(gameWorldDto));
            if (gameWorld != null) {
                List<GameWorldField> fields = GameWorldFieldFactory.createFieldsForWorld(gameWorld);
                gameWorldFieldRepository.save(fields);
            }
        } catch (DataIntegrityViolationException exception) {
            Logger.getLogger(getClass()).error("Duplicated entry name.", exception);
        }
        return Optional.ofNullable(gameWorld);
    }

    @Override
    public Optional<List<GameWorld>> getAllWolrds() {
        List<GameWorld> worldList = gameWorldRepository.getAllBy();
        return Optional.ofNullable(worldList);
    }
}
