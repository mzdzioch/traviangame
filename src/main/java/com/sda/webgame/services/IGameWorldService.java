package com.sda.webgame.services;

import com.sda.webgame.model.GameWorld;
import com.sda.webgame.model.GameWorldField;
import com.sda.webgame.model.dto.GameWorldDto;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IGameWorldService {
    Optional<GameWorld> createGameWorld(GameWorldDto dto);

    Optional<List<GameWorld>> getAllWorlds();

    Optional<List<GameWorldField>> getAllFieldsOfWorld(Long id);

    Optional<GameWorldField> getFieldWithId(Long fieldId);
}
