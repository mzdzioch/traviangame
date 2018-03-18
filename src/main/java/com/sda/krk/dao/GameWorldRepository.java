package com.sda.krk.dao;

import com.sda.krk.model.GameWorld;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface GameWorldRepository extends CrudRepository<GameWorld, Long> {
    List<GameWorld> getAllBy();
}
