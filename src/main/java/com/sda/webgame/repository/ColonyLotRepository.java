package com.sda.webgame.repository;

import com.sda.webgame.model.ColonyLot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface ColonyLotRepository extends CrudRepository<ColonyLot, Long> {

    Optional<ColonyLot> getById(Long id);
}
