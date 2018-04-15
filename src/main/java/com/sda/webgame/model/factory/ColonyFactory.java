package com.sda.webgame.model.factory;

import com.sda.webgame.model.Colony;
import com.sda.webgame.model.GameUser;
import com.sda.webgame.model.GameWorldField;
import com.sda.webgame.model.dto.CreateColonyDto;

public class ColonyFactory {
    public static Colony create(GameUser owner, GameWorldField field, CreateColonyDto dto){
        return new Colony(dto.getColonyName(), 7, field, owner);
    }
}
