package com.sda.webgame.model.dto;

import com.sda.webgame.model.BuildingType;

public class CreateBuildingDto {
    private Long userId;
    private Long lotId;
    private BuildingType buildingType;

    public CreateBuildingDto() {
    }

    public CreateBuildingDto(Long userId, Long lotId, BuildingType buildingType) {
        this.userId = userId;
        this.lotId = lotId;
        this.buildingType = buildingType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLotId() {
        return lotId;
    }

    public void setLotId(Long lotId) {
        this.lotId = lotId;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }
}

