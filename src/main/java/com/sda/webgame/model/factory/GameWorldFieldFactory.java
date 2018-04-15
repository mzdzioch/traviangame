package com.sda.webgame.model.factory;

import com.sda.webgame.model.GameWorld;
import com.sda.webgame.model.GameWorldField;
import com.sda.webgame.model.WorldFieldType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameWorldFieldFactory {
    public static List<GameWorldField> createFieldsForWorld(GameWorld world){
        List<GameWorldField> generatedFields = new ArrayList<>();

        for (int row = 0; row < world.getSizeRowsColumns(); row++) {
            for (int column = 0; column < world.getSizeRowsColumns(); column++) {
                 generatedFields.add(generatedWorldField(world, row, column));
            }
        }

        return generatedFields;

    }

    private static GameWorldField generatedWorldField(GameWorld world, int row, int column) {
        WorldFieldType generatedFieldType = WorldFieldType.values()[(new Random().nextInt(WorldFieldType.values().length))];

        return new GameWorldField(generatedFieldType, column, row, world);
    }
}
