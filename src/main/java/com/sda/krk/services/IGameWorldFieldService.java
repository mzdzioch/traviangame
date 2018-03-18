package com.sda.krk.services;

import com.sda.krk.model.GameWorldField;

import java.util.List;

public interface IGameWorldFieldService {
    List<GameWorldField> getAllFields(Long id);
}
