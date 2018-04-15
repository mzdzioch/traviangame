package com.sda.webgame.services;

import com.sda.webgame.model.Colony;
import com.sda.webgame.model.ColonyLot;
import com.sda.webgame.model.GameWorldField;
import com.sda.webgame.model.dto.ColonyDto;
import com.sda.webgame.model.dto.CreateBuildingDto;
import com.sda.webgame.model.dto.CreateColonyDto;

import java.util.List;
import java.util.Optional;

public interface IColonyService {

    public Optional<Colony> tryCreateColony(CreateColonyDto dto);

    Optional<Colony> getColony(Long id);

    Optional<Colony> getColonyByField(GameWorldField gameWorldField);

    Optional<ColonyLot> createBuilding(CreateBuildingDto dto);

    Optional<ColonyLot> getLot(Long id);

    List<ColonyDto> getColoniesByOwner(Long userId);
}
