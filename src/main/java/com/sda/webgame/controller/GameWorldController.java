package com.sda.webgame.controller;

import com.sda.webgame.model.Colony;
import com.sda.webgame.model.GameWorld;
import com.sda.webgame.model.GameWorldField;
import com.sda.webgame.model.dto.GameWorldDto;
import com.sda.webgame.model.dto.GameWorldFieldInfoDto;
import com.sda.webgame.model.response.ResponseMessage;
import com.sda.webgame.model.response.StatusResponse;
import com.sda.webgame.services.ColonyService;
import com.sda.webgame.services.IColonyService;
import com.sda.webgame.services.IGameWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/world/")
@CrossOrigin
public class GameWorldController {

    @Autowired
    private IGameWorldService gameWorldService;

    @Autowired
    private IColonyService colonyService;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseMessage<GameWorld> createGameWorld(@RequestBody GameWorldDto dto){
        Optional<GameWorld> gameWorld = gameWorldService.createGameWorld(dto);

        if(gameWorld.isPresent()){
            return new ResponseMessage<>(StatusResponse.OK, "World added.", gameWorld.get());
        } else {
            return new ResponseMessage<>(StatusResponse.SERVER_ERROR, "Error adding world.", null);
        }

    }

    @RequestMapping(path = "/getWorldFields/{id}", method = RequestMethod.GET)
    @CrossOrigin
    public ResponseMessage<List<GameWorldField>> getWorldFields(@PathVariable("id") Long id) {
        Optional<List<GameWorldField>> gameWorldFields = gameWorldService.getAllFieldsOfWorld(id);

        if (gameWorldFields.isPresent()) {
            return new ResponseMessage<>(
                    StatusResponse.OK,
                    null,
                    gameWorldFields.get());
        } else {
            return new ResponseMessage<>(
                    StatusResponse.SERVER_ERROR,
                    "Unable to retrieve worlds.",
                    null);
        }
    }


    @RequestMapping(path = "/getAllWorlds", method = RequestMethod.GET)
    public ResponseMessage<List<GameWorld>> getAllWorlds(){
        Optional<List<GameWorld>> gameWorlds = gameWorldService.getAllWorlds();

        if(gameWorlds.isPresent()){
            return new ResponseMessage<>(
                    StatusResponse.OK,
                    null,
                    gameWorlds.get()
            );
        } else {
            return new ResponseMessage<>(
                    StatusResponse.SERVER_ERROR,
                    "Unable to retrieve worlds",
                    null
            );
        }
    }

    @RequestMapping(path = "/getFieldInfo/{fieldId}")
    public ResponseMessage<GameWorldFieldInfoDto> getFieldInfo(@PathVariable(value = "fieldId") Long fieldId) {
        Optional<GameWorldField> gameWorldField = gameWorldService.getFieldWithId(fieldId);

        if(gameWorldField.isPresent()){

            Optional<Colony> colony = colonyService.getColonyByField(gameWorldField.get());

            return new ResponseMessage<>(
                    StatusResponse.OK,
                    null,
                    new GameWorldFieldInfoDto(gameWorldField.get(), colony.orElse(null)));
        } else {
            return new ResponseMessage<>(
                    StatusResponse.REQUEST_ERROR,
                    "Field does not exist",
                    null);
        }


    }


}
