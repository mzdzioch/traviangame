package com.sda.krk.dao;

import com.sda.krk.model.GameUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface GameUserRepository extends CrudRepository <GameUser, Long> {
    public GameUser getGameUserByEmail(String email);

    public GameUser getGameUserByEmailAndPasswordHash(String email, String passwordHash);
}
