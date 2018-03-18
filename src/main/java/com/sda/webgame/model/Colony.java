package com.sda.webgame.model;

import com.sda.webgame.model.factory.ColonyLotFactory;

import javax.persistence.*;
import java.util.List;

@Entity
public class Colony {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private int maxSlots;

    @OneToOne
    private GameWorldField field;

    @ManyToOne
    private GameUser owner;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ColonyLot> lotList;

    public Colony() {
    }

    public Colony(String name, int maxSlots, GameWorldField field, GameUser owner) {
        this.name = name;
        this.maxSlots = maxSlots;
        this.field = field;
        this.owner = owner;
        this.lotList = ColonyLotFactory.createEmptyColonyLots(this);
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

    public int getMaxSlots() {
        return maxSlots;
    }

    public void setMaxSlots(int maxSlots) {
        this.maxSlots = maxSlots;
    }

    public GameWorldField getField() {
        return field;
    }

    public void setField(GameWorldField field) {
        this.field = field;
    }

    public GameUser getOwner() {
        return owner;
    }

    public void setOwner(GameUser owner) {
        this.owner = owner;
    }

    public List<ColonyLot> getLotList() {
        return lotList;
    }

    public void setLotList(List<ColonyLot> lotList) {
        this.lotList = lotList;
    }
}
