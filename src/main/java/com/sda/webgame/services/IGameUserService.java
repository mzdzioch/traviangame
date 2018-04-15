package com.sda.webgame.services;

import com.sda.webgame.model.GameUser;
import com.sda.webgame.model.dto.GameUserDto;

import java.util.Optional;

public interface IGameUserService {

    Optional<GameUser> tryRegister(GameUserDto dto);

    Optional<GameUser> tryLogin(GameUserDto userData);
}
