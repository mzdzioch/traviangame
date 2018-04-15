package com.sda.webgame.model.dto;

public class ColonyDto {
    private Long fieldId;
    private String colonyName;

    public ColonyDto() {
    }

    public ColonyDto(Long fieldId, String colonyName) {
        this.fieldId = fieldId;
        this.colonyName = colonyName;
    }

    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    public String getColonyName() {
        return colonyName;
    }

    public void setColonyName(String colonyName) {
        this.colonyName = colonyName;
    }
}
