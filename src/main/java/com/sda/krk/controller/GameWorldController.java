package com.sda.krk.controller;

import com.sda.krk.model.GameWorld;
import com.sda.krk.model.dto.GameWorldDto;
import com.sda.krk.model.response.ResponseMessage;
import com.sda.krk.model.response.StatusResponse;
import com.sda.krk.services.IGameWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/world")
public class GameWorldController {

    @Autowired
    private IGameWorldService gameWorldService;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseMessage<GameWorld> createGameWorld(@RequestBody GameWorldDto gameWorldDto) {
        Optional<GameWorld> gameWorld = gameWorldService.createGameWorldService(gameWorldDto);

        if (gameWorld.isPresent()) {
            return new ResponseMessage<>(StatusResponse.OK, "world created", gameWorld.get());
        } else {
            return new ResponseMessage<>(StatusResponse.REQUEST_ERROR, "unable to create world", null);
        }
    }
}
