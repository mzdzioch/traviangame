package com.sda.krk.controller;

import com.sda.krk.model.Colony;
import com.sda.krk.model.dto.CreateColonyDto;
import com.sda.krk.model.response.ResponseMessage;
import com.sda.krk.model.response.StatusResponse;
import com.sda.krk.services.IColonyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping(path = "/colony")
@CrossOrigin
public class ColonyController {

    @Autowired
    private IColonyService colonyService;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseMessage<Colony> createColony(@RequestBody CreateColonyDto createColonyDto) {
        Optional<Colony> colony = colonyService.tryCreateColony(createColonyDto);
        if (colony.isPresent()) {
            return new ResponseMessage<>(StatusResponse.OK, "colony created", colony.get());
        } else {
            return new ResponseMessage<>(StatusResponse.REQUEST_ERROR, "colony creation failed!", null);
        }
    }

    @RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
    public ResponseMessage<Colony> getColony(@RequestParam("id") Long id) {
        Optional<Colony> colony = colonyService.getColony(id);

        if (colony.isPresent()) {
            return new ResponseMessage<>(StatusResponse.OK, null, colony.get());
        } else {
            return new ResponseMessage<>(StatusResponse.REQUEST_ERROR, "Error while getting colony", null);
        }
    }
}
