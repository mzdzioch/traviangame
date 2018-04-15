package com.sda.webgame.model.dto;

import com.sda.webgame.model.Colony;
import com.sda.webgame.model.GameWorldField;

public class GameWorldFieldInfoDto {

    private GameWorldField field;
    private Colony colony;

    public GameWorldFieldInfoDto() {
    }

    public GameWorldFieldInfoDto(GameWorldField field, Colony colony) {
        this.field = field;
        this.colony = colony;
    }

    public GameWorldField getField() {
        return field;
    }

    public void setField(GameWorldField field) {
        this.field = field;
    }

    public Colony getColony() {
        return colony;
    }

    public void setColony(Colony colony) {
        this.colony = colony;
    }
}
