package com.sda.krk.services;

import com.sda.krk.model.Colony;
import com.sda.krk.model.dto.CreateColonyDto;

import java.util.Optional;

public interface IColonyService {
    Optional<Colony> tryCreateColony(CreateColonyDto createColonyDto);
}
