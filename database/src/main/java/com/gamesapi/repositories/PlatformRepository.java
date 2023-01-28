package com.gamesapi.repositories;

import com.gamesapi.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlatformRepository extends JpaRepository<Platform, Integer> {
    Optional<Platform> findBySourceId(int id);

}
