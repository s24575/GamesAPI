package com.gamesapi.repositories;

import com.gamesapi.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Integer> {
    Optional<Game> findBySourceId(int id);

}
