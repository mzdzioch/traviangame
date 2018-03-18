package com.sda.krk.services;

import com.sda.krk.dao.GameWorldFieldRepository;
import com.sda.krk.model.GameWorldField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameWorldFieldService implements IGameWorldFieldService {
    @Autowired
    private GameWorldFieldRepository gameWorldFieldRepository;

    @Override
    public List<GameWorldField> getAllFields(Long id) {
        return null;
    }
}
