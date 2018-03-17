package com.sda.krk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GameWorld {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int sizeRowsColumns;

    public GameWorld() {
    }

    public GameWorld(String name, int sizeRowsColumns) {
        this.name = name;
        this.sizeRowsColumns = sizeRowsColumns;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
