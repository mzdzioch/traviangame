package com.sda.krk.model.dto;

public class GameWorldDto {
    private String name;
    private int sizeRowsColumns;

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
