package com.sda.webgame.services;

import com.sda.webgame.model.Colony;
import com.sda.webgame.model.dto.CreateColonyDto;

import java.util.Optional;

public interface IColonyService {

    public Optional<Colony> tryCreateColony(CreateColonyDto dto);
}
