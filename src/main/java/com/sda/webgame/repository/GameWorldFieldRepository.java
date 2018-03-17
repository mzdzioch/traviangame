package com.sda.webgame.repository;

import com.sda.webgame.model.GameWorld;
import com.sda.webgame.model.GameWorldField;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface GameWorldFieldRepository extends CrudRepository<GameWorldField, Long> {

    Optional<GameWorldField> getGameWorldFieldById(long fieldId);


}
