package com.sda.webgame.services;

import com.sda.webgame.model.GameWorld;
import com.sda.webgame.model.GameWorldField;
import com.sda.webgame.model.dto.GameWorldDto;
import com.sda.webgame.model.factory.GameWorldFactory;
import com.sda.webgame.model.factory.GameWorldFieldFactory;
import com.sda.webgame.repository.GameUserRepository;
import com.sda.webgame.repository.GameWorldFieldRepository;
import com.sda.webgame.repository.GameWorldRepository;
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
    public Optional<GameWorld> createGameWorld(GameWorldDto dto) {
        GameWorld world = null;

        try{

            world = gameWorldRepository.save(GameWorldFactory.createGameWorld(dto));

            if(world != null){
                List<GameWorldField> fields = GameWorldFieldFactory.createFieldsForWorld(world);
                gameWorldFieldRepository.save(fields);
            }

        } catch (DataIntegrityViolationException exception){

            Logger.getLogger(getClass()).error("Duplicate entry name.", exception);

        }



        return Optional.ofNullable(world);
    }
}
