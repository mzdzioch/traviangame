package com.sda.webgame.repository;

import com.sda.webgame.model.Colony;
import com.sda.webgame.model.ColonyLot;
import com.sda.webgame.model.GameWorld;
import com.sda.webgame.model.GameWorldField;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface ColonyRepository extends CrudRepository<Colony, Long>{

    boolean existsColonyByField(GameWorldField field);

    Optional<Colony> getColonyById(Long id);

    Optional<Colony> getColonyByField(GameWorldField gameWorldField);

}
