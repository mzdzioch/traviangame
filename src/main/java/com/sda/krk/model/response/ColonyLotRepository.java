package com.sda.krk.model.response;

import com.sda.krk.model.ColonyLot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ColonyLotRepository extends CrudRepository<ColonyLot, Long> {
}
