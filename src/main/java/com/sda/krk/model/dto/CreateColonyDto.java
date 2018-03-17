package com.sda.krk.model.dto;

public class CreateColonyDto {
    private long userId;
    private long fieldId;
    private String colonyName;

    public CreateColonyDto(long userId) {
        this.userId = userId;
    }

    public CreateColonyDto() {
    }

    public CreateColonyDto(long userId, long fieldId, String colonyName) {
        this.userId = userId;
        this.fieldId = fieldId;
        this.colonyName = colonyName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getFieldId() {
        return fieldId;
    }

    public void setFieldId(long fieldId) {
        this.fieldId = fieldId;
    }

    public String getColonyName() {
        return colonyName;
    }

    public void setColonyName(String colonyName) {
        this.colonyName = colonyName;
    }
}
