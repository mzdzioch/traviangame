package com.sda.krk.services;

import com.sda.krk.dao.GameUserRepository;
import com.sda.krk.model.GameUser;
import com.sda.krk.model.dto.GameUserDto;
import com.sda.krk.model.factory.GameUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameUserService implements IGameUserService {

    @Autowired
    private GameUserRepository gameUserRepository;

    @Override
    public Optional<GameUser> tryRegister(GameUserDto gameUserDto) {
        GameUser gameUser = gameUserRepository.getGameUserByEmail(gameUserDto.getEmail());
        if (gameUser != null) {
            return Optional.empty();
        } else {
            gameUser = gameUserRepository.save(GameUserFactory.createGameUser(gameUserDto));
            return Optional.ofNullable(gameUser);
        }
    }

    @Override
    public Optional<GameUser> tryLogin(GameUserDto gameUserDto) {
        GameUser gameUser = gameUserRepository.getGameUserByEmailAndPasswordHash(gameUserDto.getEmail(), gameUserDto.getPasswordHash());
        return Optional.ofNullable(gameUser);
    }
}
