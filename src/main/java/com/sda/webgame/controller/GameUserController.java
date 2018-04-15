package com.sda.webgame.controller;

import com.sda.webgame.model.GameUser;
import com.sda.webgame.model.dto.GameUserDto;
import com.sda.webgame.model.response.ResponseMessage;
import com.sda.webgame.model.response.StatusResponse;
import com.sda.webgame.services.GameUserService;
import com.sun.corba.se.impl.protocol.giopmsgheaders.RequestMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/user/")
@CrossOrigin //kominukacja pomiedzy front-end a back--end (inaczej nie mozna )
public class GameUserController {

    @Autowired
    private GameUserService gameUserService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseMessage<GameUser> registerUser(@RequestBody GameUserDto user){

        Optional<GameUser> registrationResult = gameUserService.tryRegister(user);

        if(registrationResult.isPresent()){
            return new ResponseMessage<>(StatusResponse.OK, null, registrationResult.get());
        }

        return new ResponseMessage<>(StatusResponse.REQUEST_ERROR, "Unable to register user!", null);

    }

    @RequestMapping(value = "/sign-in", method = RequestMethod.POST)
    public ResponseMessage<GameUser> loginUser(@RequestBody GameUserDto userData){
        Optional<GameUser> registrationResult = gameUserService.tryLogin(userData);

        if(registrationResult.isPresent()){
            return new ResponseMessage<>(StatusResponse.OK, "Logged in.", registrationResult.get());
        }

        return new ResponseMessage<>(StatusResponse.REQUEST_ERROR, "Invalid user or password.", null);
    }
}
