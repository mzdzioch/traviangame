package com.sda.webgame.repository;

import com.sda.webgame.model.GameUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface GameUserRepository extends CrudRepository<GameUser, Long> {

//    @Query(value = "select * from gameuser where email=?1")
    GameUser getGameUserByEmail(String email);

    GameUser getGameUserByEmailAndPasswordHash(String email, String passwordHash);

    Optional<GameUser> getGameUserById(long userId);
}
