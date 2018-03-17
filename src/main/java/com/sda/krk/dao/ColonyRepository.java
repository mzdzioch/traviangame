package com.sda.krk.dao;

import com.sda.krk.model.Colony;
import com.sda.krk.model.GameWorldField;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColonyRepository extends CrudRepository<Colony, Long> {
    boolean existsColonyByGameWorldField(GameWorldField field);
}
