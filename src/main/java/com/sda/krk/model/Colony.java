package com.sda.krk.model;

import javax.persistence.*;

@Entity
public class Colony {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private GameWorldField gameWorldField;

    private int maxSlots;

    @ManyToOne
    private GameUser owner;

    public Colony() {
    }

    public Colony(String name, GameWorldField gameWorldField, int maxSlots, GameUser owner) {
        this.name = name;
        this.gameWorldField = gameWorldField;
        this.maxSlots = maxSlots;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameWorldField getGameWorldField() {
        return gameWorldField;
    }

    public void setGameWorldField(GameWorldField gameWorldField) {
        this.gameWorldField = gameWorldField;
    }

    public int getMaxSlots() {
        return maxSlots;
    }

    public void setMaxSlots(int maxSlots) {
        this.maxSlots = maxSlots;
    }

    public GameUser getOwner() {
        return owner;
    }

    public void setOwner(GameUser owner) {
        this.owner = owner;
    }
}
