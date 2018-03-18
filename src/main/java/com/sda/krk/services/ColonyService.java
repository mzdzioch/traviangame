package com.sda.krk.services;

import com.sda.krk.dao.ColonyRepository;
import com.sda.krk.dao.GameUserRepository;
import com.sda.krk.dao.GameWorldFieldRepository;
import com.sda.krk.model.Colony;
import com.sda.krk.model.GameUser;
import com.sda.krk.model.GameWorldField;
import com.sda.krk.model.WorldFieldType;
import com.sda.krk.model.dto.CreateColonyDto;
import com.sda.krk.model.factory.ColonyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColonyService implements IColonyService {

    @Autowired
    private ColonyRepository colonyRepository;

    @Autowired
    private GameWorldFieldRepository gameWorldFieldRepository;

    @Autowired
    private GameUserRepository gameUserRepository;

    @Override
    public Optional<Colony> tryCreateColony(CreateColonyDto createColonyDto) {
        Optional<GameUser> gameUser = gameUserRepository.getGameUserById(createColonyDto.getUserId());
        if (!gameUser.isPresent()) {
            return Optional.empty();
        }

        Optional<GameWorldField> fieldToColonize = gameWorldFieldRepository.getGameWorldFieldById(createColonyDto.getFieldId());
        if (!fieldToColonize.isPresent() || fieldToColonize.get().getWorldFieldType() != WorldFieldType.GRASS) {
            return Optional.empty();
        }
        GameWorldField field = fieldToColonize.get();

        if (colonyRepository.existsColonyByGameWorldField(field)) {
            return Optional.empty();
        }

        Colony createdColony = colonyRepository.save(ColonyFactory.createColony(gameUser.get(), field, createColonyDto));
        return Optional.ofNullable(createdColony);
    }

    @Override
    public Optional<Colony> getColony(Long id) {
        Optional<Colony> colony = colonyRepository.getColonyById(id);
        return colony;
    }
}
