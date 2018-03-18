package com.sda.webgame.controller;

import com.sda.webgame.model.GameWorld;
import com.sda.webgame.model.dto.GameWorldDto;
import com.sda.webgame.model.response.ResponseMessage;
import com.sda.webgame.model.response.StatusResponse;
import com.sda.webgame.services.IGameWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/world/")
@CrossOrigin
public class GameWorldController {

    @Autowired
    private IGameWorldService gameWorldService;

    @RequestMapping(path = "create", method = RequestMethod.POST)
    public ResponseMessage<GameWorld> createGameWorld(@RequestBody GameWorldDto dto){
        Optional<GameWorld> gameWorld = gameWorldService.createGameWorld(dto);

        if(gameWorld.isPresent()){
            return new ResponseMessage<>(StatusResponse.OK, "World added.", gameWorld.get());
        } else {
            return new ResponseMessage<>(StatusResponse.SERVER_ERROR, "Error adding world", null);
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


}
