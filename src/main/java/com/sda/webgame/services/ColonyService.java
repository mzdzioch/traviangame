package com.sda.webgame.services;

import com.sda.webgame.model.Colony;
import com.sda.webgame.model.GameUser;
import com.sda.webgame.model.GameWorldField;
import com.sda.webgame.model.WorldFieldType;
import com.sda.webgame.model.dto.CreateColonyDto;
import com.sda.webgame.model.factory.ColonyFactory;
import com.sda.webgame.repository.ColonyRepository;
import com.sda.webgame.repository.GameUserRepository;
import com.sda.webgame.repository.GameWorldFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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
    public Optional<Colony> tryCreateColony(CreateColonyDto dto) {
        //sprawdzamy czy istnieje user
        Optional<GameUser> userCreatingColony = gameUserRepository.getGameUserById(dto.getUserId());

        if(!userCreatingColony.isPresent()){
            return Optional.empty();
        }

        //sprawdzamy czy istnieje pole
        Optional<GameWorldField> fieldOnWhichColonyIsToBePlaced =
                gameWorldFieldRepository.getGameWorldFieldById(dto.getFieldId());

        if(!fieldOnWhichColonyIsToBePlaced.isPresent()){
            return Optional.empty();
        }

        //sprawdzamy czy na polu jest trawa(mozna sie osiedlic)

        GameWorldField field = fieldOnWhichColonyIsToBePlaced.get();
        if(field.getFieldTyp() != WorldFieldType.GRASS){
            return Optional.empty();
        }

        //sprawdzamy czy na danym polu nie znajduje sie colonia
        if(colonyRepository.existsColonyByField(field)){
            return Optional.empty();
        }

        //all data has been validated
        Colony createdColony = ColonyFactory.create(
                userCreatingColony.get(), field, dto);
        createdColony = colonyRepository.save(createdColony);

        return Optional.ofNullable(createdColony);
    }
}
