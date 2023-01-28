package com.gamesapi.repositories;

import com.gamesapi.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
    Optional<Language> findBySourceId(int id);

}
