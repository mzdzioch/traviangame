package com.sda.webgame.model.factory;

import com.sda.webgame.model.BuildingType;
import com.sda.webgame.model.Colony;
import com.sda.webgame.model.ColonyLot;

import java.util.ArrayList;
import java.util.List;

public class ColonyLotFactory {

    public static List<ColonyLot> createEmptyColonyLots(Colony colony){
        List<ColonyLot> colonyLots = new ArrayList<>();

        for (int i = 0; i < colony.getMaxSlots(); i++) {
             colonyLots.add(new ColonyLot(BuildingType.NONE, 0 ,colony));

        }

        return colonyLots;
    }

}
