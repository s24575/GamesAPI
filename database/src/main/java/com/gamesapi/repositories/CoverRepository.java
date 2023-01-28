package com.gamesapi.repositories;

import com.gamesapi.model.Cover;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoverRepository extends JpaRepository<Cover, Integer> {
    Optional<Cover> findBySourceId(int id);

}
