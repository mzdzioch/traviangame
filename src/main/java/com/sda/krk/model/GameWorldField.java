package com.sda.krk.model;

import javax.persistence.*;

@Entity
public class GameWorldField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private WorldFieldType worldFieldType;
    private int positionColumn;
    private int positionRow;

    @ManyToOne
    private GameWorld gameWorld;

    public GameWorldField(WorldFieldType worldFieldType, int positionColumn, int positionRow, GameWorld gameWorld) {
        this.worldFieldType = worldFieldType;
        this.positionColumn = positionColumn;
        this.positionRow = positionRow;
        this.gameWorld = gameWorld;
    }

    public GameWorldField() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public WorldFieldType getWorldFieldType() {
        return worldFieldType;
    }

    public void setWorldFieldType(WorldFieldType worldFieldType) {
        this.worldFieldType = worldFieldType;
    }

    public int getPositionColumn() {
        return positionColumn;
    }

    public void setPositionColumn(int positionColumn) {
        this.positionColumn = positionColumn;
    }

    public int getPositionRow() {
        return positionRow;
    }

    public void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public GameWorld getGameWorld() {
        return gameWorld;
    }

    public void setGameWorld(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }
}
