package com.sda.krk.controller;

import com.sda.krk.model.GameWorld;
import com.sda.krk.model.GameWorldField;
import com.sda.krk.model.dto.GameWorldDto;
import com.sda.krk.model.response.ResponseMessage;
import com.sda.krk.model.response.StatusResponse;
import com.sda.krk.services.IGameWorldFieldService;
import com.sda.krk.services.IGameWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/world")
@CrossOrigin
public class GameWorldController {

    @Autowired
    private IGameWorldService gameWorldService;

    @Autowired
    private IGameWorldFieldService gameWorldFieldService;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseMessage<GameWorld> createGameWorld(@RequestBody GameWorldDto gameWorldDto) {
        Optional<GameWorld> gameWorld = gameWorldService.createGameWorldService(gameWorldDto);

        if (gameWorld.isPresent()) {
            return new ResponseMessage<>(StatusResponse.OK, "world created", gameWorld.get());
        } else {
            return new ResponseMessage<>(StatusResponse.REQUEST_ERROR, "unable to create world", null);
        }
    }

    @RequestMapping(path = "/getAllWorlds", method = RequestMethod.GET)
    public ResponseMessage<List<GameWorld>> getAllWorlds() {
        Optional<List<GameWorld>> gameWorlds = gameWorldService.getAllWolrds();

        if (gameWorlds.isPresent()) {
            return new ResponseMessage<>(StatusResponse.OK, null, gameWorlds.get());
        } else {
            return new ResponseMessage<>(StatusResponse.SERVER_ERROR, "unable to retrieve wolds", null);
        }
    }

    @RequestMapping(path = "/getWorldFields", method = RequestMethod.GET)
    public ResponseMessage<List<GameWorldField>> getWorldFields(Long id) {
        List<GameWorldField> fieldList = gameWorldFieldService.getAllFields(id);
    }
}
