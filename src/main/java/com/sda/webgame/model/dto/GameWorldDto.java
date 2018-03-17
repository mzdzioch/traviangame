package com.sda.webgame.model.dto;

public class GameWorldDto {
    private String name;
    private int sizeRowsColumns;

    public GameWorldDto() {
    }

    public GameWorldDto(String name, int sizeRowsColumns) {
        this.name = name;
        this.sizeRowsColumns = sizeRowsColumns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSizeRowsColumns() {
        return sizeRowsColumns;
    }

    public void setSizeRowsColumns(int sizeRowsColumns) {
        this.sizeRowsColumns = sizeRowsColumns;
    }
}
