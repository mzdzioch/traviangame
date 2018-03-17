package com.sda.krk.dao;

import com.sda.krk.model.GameWorldField;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface GameWorldFieldRepository extends CrudRepository<GameWorldField, Long> {

}
