package com.sda.webgame.repository;

import com.sda.webgame.model.GameWorld;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface GameWorldRepository extends CrudRepository<GameWorld, Long>{




}
