package com.sda.krk.dao;

import com.sda.krk.model.GameUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface GameUserRepository extends CrudRepository <GameUser, Long> {
    GameUser getGameUserByEmail(String email);

    GameUser getGameUserByEmailAndPasswordHash(String email, String passwordHash);

    Optional<GameUser> getGameUserById(Long id);
}
