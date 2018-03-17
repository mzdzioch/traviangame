package com.sda.krk.dao;

import com.sda.krk.model.GameWorldField;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface GameWorldFieldRepository extends CrudRepository<GameWorldField, Long> {

    Optional<GameWorldField> getGameWorldFieldById(long fieldId);
}
