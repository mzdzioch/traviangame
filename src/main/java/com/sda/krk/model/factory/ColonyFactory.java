package com.sda.krk.model.factory;

import com.sda.krk.model.Colony;
import com.sda.krk.model.GameUser;
import com.sda.krk.model.GameWorldField;
import com.sda.krk.model.dto.CreateColonyDto;

public class ColonyFactory {

    public static Colony createColony(GameUser owner, GameWorldField field, CreateColonyDto createColonyDto) {
        return new Colony(createColonyDto.getColonyName(), field, 7, owner);
    }
}
