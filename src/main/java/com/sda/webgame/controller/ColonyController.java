package com.sda.webgame.controller;

import com.sda.webgame.model.BuildingType;
import com.sda.webgame.model.Colony;
import com.sda.webgame.model.ColonyLot;
import com.sda.webgame.model.dto.ColonyDto;
import com.sda.webgame.model.dto.CreateBuildingDto;
import com.sda.webgame.model.dto.CreateColonyDto;
import com.sda.webgame.model.response.ResponseMessage;
import com.sda.webgame.model.response.StatusResponse;
import com.sda.webgame.services.IColonyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.plugin2.message.ShowStatusMessage;

import javax.websocket.server.PathParam;
import java.util.*;

@RestController
@RequestMapping(path = "/colony/")
@CrossOrigin
public class ColonyController {

    @Autowired
    private IColonyService colonyService;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseMessage<Colony> createColony(@RequestBody CreateColonyDto dto) {

        Optional<Colony> createColony = colonyService.tryCreateColony(dto);

        if(createColony.isPresent()){
            return new ResponseMessage<>(StatusResponse.OK, "Colony created.", createColony.get());
        } else {
            return new ResponseMessage<>(
                    StatusResponse.REQUEST_ERROR, "Error while creating colony", null);
        }

    }

    @RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
    public ResponseMessage<Colony> getColony(@PathParam("id") Long id) {
        Optional<Colony> colony = colonyService.getColony(id);

        if(colony.isPresent()){
            Collections.sort(colony.get().getLotList(), Comparator.comparingLong(ColonyLot::getId));
            return new ResponseMessage<>(
                    StatusResponse.OK, null, colony.get());
        } else {
            return new ResponseMessage<>(
                    StatusResponse.REQUEST_ERROR, "Error while getting colony", null);
        }
    }


    @RequestMapping(path = "/getLotInfo/{id}", method = RequestMethod.GET)
    public ResponseMessage<ColonyLot> getLotInfo(@PathVariable("id") Long id) {
        Optional<ColonyLot> lot = colonyService.getLot(id);
        if (lot.isPresent()) {
            return new ResponseMessage<>(
                    StatusResponse.OK,
                    null,
                    lot.get());
        } else {
            return new ResponseMessage<>(
                    StatusResponse.REQUEST_ERROR,
                    "Lot with this id does not exist.",
                    null);
        }
    }

    @RequestMapping(path = "/getBuildingTypes", method = RequestMethod.GET)
    public ResponseMessage<List<BuildingType>> getBuildingTypes() {
        return new ResponseMessage<>(
                StatusResponse.OK,
                null,
                Arrays.asList(BuildingType.values()));
    }

    @RequestMapping(path = "/createBuilding", method = RequestMethod.POST)
    public ResponseMessage<ColonyLot> createBuildingOnLot(@RequestBody CreateBuildingDto dto) {
        Optional<ColonyLot> lot = colonyService.createBuilding(dto);
        if (lot.isPresent()) {
            return new ResponseMessage<>(
                    StatusResponse.OK,
                    null,
                    lot.get());
        } else {
            return new ResponseMessage<>(
                    StatusResponse.REQUEST_ERROR,
                    "Unable to create that building.",
                    null);
        }
    }

    @RequestMapping(path = "/getUserColonies", method = RequestMethod.GET)
    public ResponseMessage<List<ColonyDto>> getUserColonies(@RequestParam("userId") Long userId) {
        List<ColonyDto> userColonies = colonyService.getColoniesByOwner(userId);

        return new ResponseMessage<>(
                StatusResponse.OK,
                null,
                userColonies);
    }
}
