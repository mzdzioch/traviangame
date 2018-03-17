package com.sda.krk.services;

import com.sda.krk.model.GameUser;
import com.sda.krk.model.dto.GameUserDto;

import java.util.Optional;

public interface IGameUserService {
    public Optional<GameUser> tryRegister(GameUserDto gameUserDto);

    Optional<GameUser> tryLogin(GameUserDto gameUserDto);
}
