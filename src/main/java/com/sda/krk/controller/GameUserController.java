package com.sda.krk.controller;

import com.sda.krk.model.GameUser;
import com.sda.krk.model.dto.GameUserDto;
import com.sda.krk.model.response.ResponseMessage;
import com.sda.krk.model.response.StatusResponse;
import com.sda.krk.services.IGameUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class GameUserController {

    @Autowired
    private IGameUserService gameUserService;

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public ResponseMessage<GameUser> registerUser(@RequestBody GameUserDto gameUserDto) {
        Optional<GameUser> registrationResult = gameUserService.tryRegister(gameUserDto);
        if (registrationResult.isPresent()) {
            return new ResponseMessage<>(StatusResponse.OK, "register successful!", registrationResult.get());
        }
        throw new IllegalArgumentException();
    }

    @RequestMapping(path = "/sign-in", method = RequestMethod.POST)
    public ResponseMessage<GameUser> loginUser(@RequestBody GameUserDto gameUserDto) {
        Optional<GameUser> registrationResult = gameUserService.tryLogin(gameUserDto);

        if (registrationResult.isPresent()) {
            return new ResponseMessage<>(StatusResponse.OK, "logged in", registrationResult.get());
        } else {
            return new ResponseMessage<>(StatusResponse.REQUEST_ERROR, "invalid email or password", registrationResult.get());
        }
    }

}
