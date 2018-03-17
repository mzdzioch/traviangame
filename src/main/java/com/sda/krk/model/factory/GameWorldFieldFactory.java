package com.sda.krk.model.factory;

import com.sda.krk.model.GameWorld;
import com.sda.krk.model.GameWorldField;
import com.sda.krk.model.WorldFieldType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameWorldFieldFactory {
    private static Random random = new Random();

    public static List<GameWorldField> createFieldsForWorld(GameWorld gameWorld) {
        List<GameWorldField> generatedFields = new ArrayList<>();
        for (int row = 0; row < gameWorld.getSizeRowsColumns(); row++) {
            for (int column = 0; column < gameWorld.getSizeRowsColumns(); column++) {
                generatedFields.add(generateGameWorldField(gameWorld, row, column));
            }
        }
        return generatedFields;
    }

    private static GameWorldField generateGameWorldField(GameWorld gameWorld, int row, int column) {
        WorldFieldType fieldType = WorldFieldType.values()[random.nextInt(WorldFieldType.values().length)];
        return new GameWorldField(fieldType, row, column, gameWorld);
    }
}
