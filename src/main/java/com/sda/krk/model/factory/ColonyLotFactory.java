package com.sda.krk.model.factory;

import com.sda.krk.model.BuildingType;
import com.sda.krk.model.Colony;
import com.sda.krk.model.ColonyLot;

import java.util.ArrayList;
import java.util.List;

public class ColonyLotFactory {
    public static List<ColonyLot> createEmptyLots(Colony colony) {
        List<ColonyLot> colonyLots = new ArrayList<>();
        for (int i = 0; i < colony.getMaxSlots(); i++) {
            colonyLots.add(new ColonyLot(BuildingType.NONE, 0, null, colony));
        }
        return colonyLots;
    }
}
