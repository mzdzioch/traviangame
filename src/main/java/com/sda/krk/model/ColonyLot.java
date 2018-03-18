package com.sda.krk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ColonyLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BuildingType buildingType;

    private int level;

    private LocalDateTime upgradeFinishTime;

    @ManyToOne
    @JsonIgnore
    private Colony colony;

    public ColonyLot(BuildingType buildingType, int level, LocalDateTime upgradeFinishTime, Colony colony) {
        this.buildingType = buildingType;
        this.level = level;
        this.upgradeFinishTime = upgradeFinishTime;
        this.colony = colony;
    }
}
